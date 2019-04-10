package com.gpms.service;

import com.gpms.dao.domain.Student;
import com.gpms.dao.domain.entity.StudentDetail;

import java.util.List;

public interface StudentService {
    List<Student> getStudentNotAllotted();
    int insertStudentDetail(StudentDetail detail);
    int updateStudentDetail(StudentDetail detail);
}
