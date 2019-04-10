package com.gpms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gpms.dao.domain.Student;
import com.gpms.dao.domain.entity.StudentDetail;
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

    @Override
    public int insertStudentDetail(StudentDetail detail) {
        return studentMapper.insert(detail);
    }

    @Override
    public int updateStudentDetail(StudentDetail detail) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("owner", detail.getOwner());
        StudentDetail one = studentMapper.selectOne(wrapper);
        if (one == null) {
            return insertStudentDetail(detail);
        } else {
            return insertStudentDetail(detail);
        }
    }
}
