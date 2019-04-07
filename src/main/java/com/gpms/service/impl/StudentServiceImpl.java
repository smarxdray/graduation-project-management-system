package com.gpms.service.impl;

import com.gpms.dao.domain.Student;
import com.gpms.dao.mapper.StudentMapper;
import com.gpms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> getStudentNotAllotted() {
        return studentMapper.selectStudentsNotAllotted();
    }
}
