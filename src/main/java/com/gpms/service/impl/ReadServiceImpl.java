package com.gpms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gpms.dao.*;
import com.gpms.domain.Student;
import com.gpms.domain.Teacher;
import com.gpms.domain.dto.ProjectDTO;
import com.gpms.domain.entity.*;
import com.gpms.exception.FileException;
import com.gpms.service.ReadService;
import com.gpms.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class ReadServiceImpl implements ReadService {
    @Autowired
    CollegeMapper collegeMapper;
    @Autowired
    MajorMapper majorMapper;
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    private FileMapper fileMapper;
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CommentMapper commentMapper;


    @Override
    public Comment getComment(Integer id) {
        return commentMapper.selectById(id);
    }

    @Override
    public List<Comment> getComments(Integer author, Integer target) {
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        if (author != null) wrapper.eq("author", author);
        if (target != null) wrapper.eq("target", target);
        return commentMapper.selectList(wrapper);
    }

    @Override
    public ProjectDTO getProject(Integer id) {
        return projectMapper.selectProject(id);
    }

    @Override
    public List<ProjectDTO> getProjects(Integer status, Integer teacher) {
        return projectMapper.selectProjects(status, teacher);
    }
    @Override
    public List<FileInfo> getFileInfos() {
        return fileMapper.selectList(null);
    }

    @Override
    public FileInfo getFileInfoById(Integer id) {
        return fileMapper.selectById(id);
    }

    @Override
    public List<FileInfo> getFileInfosByOwner(Integer ownerId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("owner", ownerId);
        return fileMapper.selectList(wrapper);
    }

    @Override
    public List<College> getColleges() {
        return collegeMapper.selectList(null);
    }

    @Override
    public List<Major> getMajors() {
        return majorMapper.selectList(null);
    }

    @Override
    public List<Major> getMajorsByCollege(Integer collegeId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("college", collegeId);
        return majorMapper.selectList(wrapper);
    }

    @Override
    public Project getProjectsById(Integer id) {
        return projectMapper.selectById(id);
    }
    @Override
    public List<Role> getRoles() {
        return roleMapper.selectList(null);
    }
    @Override
    public List<Student> getStudentsAllottedOrNot(boolean allotted) {
        return studentMapper.selectStudentsAllottedOrNot(allotted);
    }

    @Override
    public List<Student> getStudentsByTeacher(Integer teacherId) {
        return studentMapper.selectStudentsByTeacher(teacherId);
    }

    @Override
    public List<StudentDetail> getStudentDetailsByTeacher(Integer teacherId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("teacher", teacherId);
        return studentMapper.selectList(wrapper);
    }
    @Override
    public List<Teacher> getTeachersByMajor(Integer majorId) {
        return teacherMapper.selectTeachersByMajor(majorId);
    }

    @Override
    public List<Teacher> getTeachers(String name, Integer college, Integer major, Integer projectStatus) {
        return teacherMapper.selectTeachers(name, college, major, projectStatus);
    }

    @Override
    public TeacherDetail getTeacherDetailByOwner(Integer owner) {
        QueryWrapper<TeacherDetail> wrapper = new QueryWrapper<>();
        wrapper.eq("owner", owner);
        return teacherMapper.selectOne(wrapper);
    }
    @Override
    public List<Project> getProjectsByTeacher(Integer id) {
        QueryWrapper<Project> wrapper = new QueryWrapper<>();
        wrapper.eq("teacher", id);
        return projectMapper.selectList(wrapper);
    }

    @Override
    public List<Teacher> getTeachersHavingProjects(Integer projectStatus) {
        return teacherMapper.selectTeachersHavingProjects(projectStatus);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public User getUserByCode(String code) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("code", code);
        return userMapper.selectOne(wrapper);
    }

    @Override
    public TeacherDetail getTeacherDetail(Integer id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("owner", id);
        return teacherMapper.selectOne(wrapper);
    }

    @Override
    public StudentDetail getStudentDetail(Integer id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("owner", id);
        return studentMapper.selectOne(wrapper);
    }

    @Override
    public List<User> getUsers() {
        return userMapper.selectList(null);
    }

    @Override
    public List<User> getTeachers() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Constant.PARAM_ROLE, Constant.ROLE_TEACHER);
        return userMapper.selectList(queryWrapper);
    }

    @Override
    public List<User> getUsers(Integer role) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Constant.PARAM_ROLE, role);
        return userMapper.selectList(queryWrapper);
    }

    @Override
    public List<User> getStudents() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Constant.PARAM_ROLE,  Constant.ROLE_STUDENT);
        return userMapper.selectList(queryWrapper);
    }
    @Override
    public List<Notice> getNotices() {
        return noticeMapper.selectList(null);
    }

    @Override
    public Notice getNoticeById(Integer id) {
        return noticeMapper.selectById(id);
    }

    @Override
    public List<Notice> getNoticesByReceiver(Integer userId) {
        return noticeMapper.getNoticesByReceiver(userId);
    }
    @Override
    public byte[] read(FileInfo fileInfo) throws FileException {
        if (fileInfo == null ) throw new FileException(500, "下载文件不存在！");
        String filePath = fileInfo.getPath();
        if (filePath != null) {
            File file = new File(filePath);
            if (file.exists()) {
                try {
                    InputStream in = new FileInputStream(file);
                    byte[] body = new byte[in.available()];
                    in.read(body);
                    return body;
                } catch (FileNotFoundException e) {
                    throw new FileException(500, "下载文件不存在！");
                } catch (IOException e) {
                    throw new FileException(505, "下载出现错误！");
                }
            }
        }
        return null;
    }

    @Override
    public List<FileInfo> getFileInfos(Integer role) {
        return fileMapper.getFileInfosByRole(role);
    }

}
