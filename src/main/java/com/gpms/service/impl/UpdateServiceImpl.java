package com.gpms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gpms.dao.domain.entity.Project;
import com.gpms.dao.domain.entity.StudentDetail;
import com.gpms.dao.domain.entity.TeacherDetail;
import com.gpms.dao.domain.entity.User;
import com.gpms.dao.mapper.ProjectMapper;
import com.gpms.dao.mapper.StudentMapper;
import com.gpms.dao.mapper.TeacherMapper;
import com.gpms.dao.mapper.UserMapper;
import com.gpms.service.UpdateService;
import com.gpms.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UpdateServiceImpl implements UpdateService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    @Transactional
    public int setAssignments(List<StudentDetail> assigned, List<StudentDetail> unassigned) {
        int lines = 0;
        if (assigned != null && assigned.size() != 0) {
            for (StudentDetail detail: assigned) {
                detail.setStatus(Constant.STUDENT_STATUS_IDLE);
                int ln = studentMapper.updateById(detail);
                if (ln <= 0) studentMapper.insert(detail);
                lines++;
            }
            Integer teacherId = assigned.get(0).getTeacher();
            TeacherDetail teacherDetail = new TeacherDetail();
            teacherDetail.setStudentNumber(lines);
            UpdateWrapper<TeacherDetail> wrapper = new UpdateWrapper<>();
            wrapper.eq("owner", teacherId);
            teacherMapper.update(teacherDetail, wrapper);
        }

        if (unassigned != null && unassigned.size() != 0) {
            for (StudentDetail detail: unassigned) {
                UpdateWrapper<StudentDetail> w = new UpdateWrapper<>();
                w.eq("id", detail.getId());
                w.set("teacher", null);
                w.set("status", Constant.STUDENT_STATUS_UNASSIGNED);
                studentMapper.update(detail, w);
            }
        }
        return lines;
    }

    @Override
    public boolean selectProject(Integer student, Integer project) {
        UpdateWrapper<StudentDetail> ws = new UpdateWrapper<>();
        ws.eq("owner", student);
        ws.set("project", project);
        ws.set("status", Constant.STUDENT_STATUS_WORKING);
        int lines = studentMapper.update(new StudentDetail(), ws);
        UpdateWrapper<Project> wp = new UpdateWrapper<>();
        wp.eq("id", project);
        wp.set("student", student);
        wp.set("status", Constant.PROJECT_STATUS_CLAIMED);
        lines += projectMapper.update(new Project(), wp);
        return lines == 2;
    }

    @Override
    public boolean unselectProject(Integer student, Integer project) {
        UpdateWrapper<StudentDetail> ws = new UpdateWrapper<>();
        ws.eq("owner", student);
        ws.set("project", null);
        ws.set("status", Constant.STUDENT_STATUS_IDLE);
        int lines = studentMapper.update(new StudentDetail(), ws);
        UpdateWrapper<Project> wp = new UpdateWrapper<>();
        wp.eq("id", project);
        wp.set("student", null);
        wp.set("status", Constant.PROJECT_STATUS_UNCLAIMED);
        lines += projectMapper.update(new Project(), wp);
        return lines == 2;
    }

    @Override
    @Transactional
    public int updateProjects(Project template) {
        Integer teacher = template.getTeacher();
        Integer status = template.getStatus();
        UpdateWrapper<Project> wrapper = new UpdateWrapper<>();
        wrapper.eq("teacher", teacher);
        wrapper.set("status", status);
        projectMapper.update(template, wrapper);
        UpdateWrapper<TeacherDetail> w = new UpdateWrapper<>();
        w.eq("owner", teacher);
        w.set("project_status", status);
        return teacherMapper.update(new TeacherDetail(), w);
    }

    @Override
    public int updateStudentDetailByOwner(StudentDetail detail) {
        UpdateWrapper<StudentDetail> wrapper = new UpdateWrapper<>();
        wrapper.eq("owner", detail.getOwner());
        return studentMapper.update(detail, wrapper);
    }

    @Override
    public int updateTeacherDetailByOwner(TeacherDetail detail) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("owner", detail.getOwner());
        return teacherMapper.update(detail, wrapper);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    @Transactional
    public int setReviewTimes(Integer owner) {
        int lines = 0;
        User user = userMapper.selectById(owner);
        switch (user.getRole()) {
            case Constant.ROLE_STUDENT:
                QueryWrapper<StudentDetail> wrapper = new QueryWrapper<>();
                wrapper.eq("owner", owner);
                StudentDetail studentDetail = studentMapper.selectOne(wrapper);
                int reviewTimes = studentDetail.getReviewTimes() + 1;
                studentDetail.setReviewTimes(reviewTimes);
                studentDetail.setOwner(owner);
                lines = updateStudentDetailByOwner(studentDetail);
                break;
        }
        return lines;
    }
}
