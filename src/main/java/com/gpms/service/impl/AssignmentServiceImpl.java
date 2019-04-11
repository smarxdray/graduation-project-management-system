package com.gpms.service.impl;

import com.gpms.dao.domain.entity.StudentDetail;
import com.gpms.dao.domain.entity.TeacherDetail;
import com.gpms.service.AssignmentService;
import com.gpms.service.StudentService;
import com.gpms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssignmentServiceImpl implements AssignmentService {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    @Override
    @Transactional
    public int assignBatchStudents(List<StudentDetail> details) {
        int lines = 0;
        for (StudentDetail detail: details) {
            lines += studentService.updateStudentDetail(detail);
        }
        TeacherDetail teacherDetail = new TeacherDetail();
        teacherDetail.setOwner(details.get(0).getTeacher());
        teacherDetail.setStudentNumber(lines);
        teacherService.updateTeacherDetail(teacherDetail);
        return lines;
    }
}
