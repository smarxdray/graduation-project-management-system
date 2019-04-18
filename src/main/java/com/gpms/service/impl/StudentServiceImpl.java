package com.gpms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gpms.dao.domain.Student;
import com.gpms.dao.domain.entity.Project;
import com.gpms.dao.domain.entity.StudentDetail;
import com.gpms.dao.mapper.ProjectMapper;
import com.gpms.dao.mapper.StudentMapper;
import com.gpms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    ProjectMapper projectMapper;

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
    public int addStudentDetail(StudentDetail detail) {
        return studentMapper.insert(detail);
    }

    @Override
    public int updateStudentDetailById(StudentDetail detail) {
        UpdateWrapper<StudentDetail> wrapper = new UpdateWrapper<>();
        wrapper.set("teacher", null);
        return studentMapper.update(detail, wrapper);
    }

    @Override
    @Transactional
    public int selectProject(Integer student, Integer project) {
        UpdateWrapper<StudentDetail> ws = new UpdateWrapper<>();
        ws.eq("owner", student);
        ws.set("project", project);
        studentMapper.update(new StudentDetail(), ws);
        UpdateWrapper<Project> wp = new UpdateWrapper<>();
        wp.eq("id", project);
        wp.set("student", student);
        wp.set("status", 111);
        return projectMapper.update(new Project(), wp);
    }
}
