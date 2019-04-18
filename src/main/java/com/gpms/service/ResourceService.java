package com.gpms.service;

import com.gpms.dao.domain.entity.StudentDetail;

public interface ResourceService {
    StudentDetail getStudentDetail(Integer owner);
}
