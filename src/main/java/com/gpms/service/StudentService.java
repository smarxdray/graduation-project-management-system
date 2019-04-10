package com.gpms.service;

import com.gpms.dao.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudentNotAllotted();
}
