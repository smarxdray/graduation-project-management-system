package com.gpms.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gpms.dao.*;
import com.gpms.domain.entity.*;
import com.gpms.exception.FileException;
import com.gpms.service.CreateService;
import com.gpms.service.ReadService;
import com.gpms.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class CreateServiceImpl implements CreateService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private FileMapper fileMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private PrivateNoticeMapper privateNoticeMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ReadService readService;

    @Override
    @Transactional
    public int write(List<MultipartFile> files, Integer userId) throws FileException {
        int lines = 0;
        String personalDir = String.valueOf(userId);
        String path = Constant.FILE_DIR + File.separator + personalDir;
        StudentDetail detail = readService.getStudentDetail(userId);
        if (detail != null ) {
            detail.setFileDir(path);
            UpdateWrapper<StudentDetail> wrapper = new UpdateWrapper<>();
            wrapper.eq("owner", userId);
            studentMapper.update(detail, wrapper);
        }
        for (int i = 0; i < files.size(); ++i) {
            MultipartFile file = files.get(i);
            String fullPath = write(path, files.get(i), i);
            String filename = file.getOriginalFilename();
            String suffixName = Objects.requireNonNull(filename).substring(filename.lastIndexOf(".") + 1);
            Integer size = Math.toIntExact(file.getSize());

            FileInfo fileInfo = new FileInfo();
            fileInfo.setName(filename.substring(0, filename.lastIndexOf(".")));
            fileInfo.setPath(fullPath);
            fileInfo.setExtension(suffixName);
            fileInfo.setSize(size);
            fileInfo.setOwner(userId);
            lines += fileMapper.insert(fileInfo);
        }
        return lines;
    }

    @Override
    @Transactional
    public int addNotice(Notice notice, List<PrivateNotice> privateNotices) {
        int lines = noticeMapper.insert(notice);
        if (lines > 0) {
            if (privateNotices != null) {
                int ln = 0;
                for (PrivateNotice p : privateNotices) {
                    p.setOwner(notice.getId());
                    ln += privateNoticeMapper.insert(p);
                }
                return ln != privateNotices.size() ? -1 : lines;
            }
        }
        return lines;
    }

    @Override
    public String write(String path, MultipartFile file, int idx) throws FileException {
        try {
            if (file.isEmpty()) {
                throw new FileException(400, "上传出错：文件不可为空！");
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 设置文件存储路径
            String fullPath = path + File.separator + fileName;
            File dest = new File(fullPath);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(dest);// 文件写入
            return fullPath;
        } catch (IllegalStateException | IOException e) {
            throw new FileException(401, "第" + idx + "个文件上传出错：" + e.getMessage());
        }

//        BufferedOutputStream stream;
//        if (!file.isEmpty()) {
//            try {
//                String filePath = Constant.FILE_DIR;
//                byte[] bytes = file.getBytes();
//                stream = new BufferedOutputStream(new FileOutputStream(
//                        new File(filePath + file.getOriginalFilename())));//设置文件路径及名字
//                stream.write(bytes);// 写入
//                stream.close();
//            } catch (Exception e) {
//                throw new FileException(400, "第 " + idx + " 个文件上传出错: "
//                        + e.getMessage());
//            }
//        } else {
//            throw new FileException(401, "第 " + idx
//                    + " 个文件上传出错: 文件为空!");
//        }
    }

    @Override
    public int addStudentDetail(StudentDetail detail) {
        return studentMapper.insert(detail);
    }

    @Override
    public int addTeacherDetail(TeacherDetail detail) {
        return teacherMapper.insert(detail);
    }
    @Override
    @Transactional
    public int addProjects(List<Project> projects) {
        if (projects == null || projects.size() == 0) return 0;
        Integer teacher = projects.get(0).getTeacher();
        Integer status = projects.get(0).getStatus();
        int lines = 0;
        for (Project p : projects) {
            int ln = projectMapper.updateById(p);
            if (ln <= 0) {
                ln = projectMapper.insert(p);
            }
            lines += ln;
        }
        UpdateWrapper<TeacherDetail> w = new UpdateWrapper<>();
        w.eq("owner", teacher);
        w.set("project_status", status);
        teacherMapper.update(new TeacherDetail(), w);
        return lines;
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int addComment(Comment comment) {

        int userId = comment.getTarget();
        if (userMapper.selectById(userId).getRole() == Constant.ROLE_STUDENT) {
            UpdateWrapper<StudentDetail> wrapper = new UpdateWrapper<>();
            wrapper.eq("owner", userId);
            int mark = comment.getMark();
            wrapper.set("status", mark < 60 ?
            Constant.STUDENT_STATUS_DISQUALIFIED : Constant.STUDENT_STATUS_QUALIFIED);
        }
        return commentMapper.insert(comment);
    }
}
