package com.gpms.service;

import com.gpms.dao.domain.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getProjects();
    Project getProjectsById(Integer id);
    int updateProjects(Project template);
}
