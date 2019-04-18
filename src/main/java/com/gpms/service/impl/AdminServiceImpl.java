package com.gpms.service.impl;

import com.gpms.dao.mapper.ProjectMapper;
import com.gpms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    ProjectMapper projectMapper;

    @Override
    public List<Map<String, Object>> getFullProjects() {
        return projectMapper.selectFullProjects();
    }
}
