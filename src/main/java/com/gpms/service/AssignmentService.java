package com.gpms.service;

import com.gpms.dao.domain.entity.StudentDetail;

import java.util.List;

public interface AssignmentService {
    int setAssignments(List<StudentDetail> assigned, List<StudentDetail> unassigned);
}