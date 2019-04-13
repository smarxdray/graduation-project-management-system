package com.gpms.service;

import com.gpms.dao.domain.entity.StudentDetail;

import java.util.List;

public interface AssignmentService {
    int assignBatchStudents(List<StudentDetail> details);
}
