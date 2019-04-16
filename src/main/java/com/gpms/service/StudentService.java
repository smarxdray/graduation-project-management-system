package com.gpms.service;

import com.gpms.dao.domain.Student;
import com.gpms.dao.domain.entity.StudentDetail;

import java.util.List;

public interface StudentService {
    int addStudentDetail(StudentDetail detail);
    List<Student> getStudentsAllottedOrNot(boolean allotted);
    List<Student> getStudentsByTeacher(Integer teacherId);
    List getStudentDetailsByTeacher(Integer teacherId);
    int updateStudentDetailById(StudentDetail detail);
}
