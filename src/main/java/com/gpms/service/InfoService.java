package com.gpms.service;

import com.gpms.dao.domain.entity.College;
import com.gpms.dao.domain.entity.Major;

import java.util.List;

public interface InfoService {
    List<College> getColleges();
    List<Major> getMajors();
    List<Major> getMajorsByCollege(Integer collegeId);
}
