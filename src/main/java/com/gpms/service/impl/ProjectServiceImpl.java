package com.gpms.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gpms.dao.domain.entity.Project;
import com.gpms.dao.domain.entity.TeacherDetail;
import com.gpms.dao.mapper.ProjectMapper;
import com.gpms.dao.mapper.TeacherMapper;
import com.gpms.service.ProjectService;
import com.gpms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<Project> getProjects() {
        return projectMapper.selectList(null);
    }

    @Override
    public Project getProjectsById(Integer id) {
        return projectMapper.selectById(id);
    }

    @Override
    @Transactional
    public int updateProjects(Project template) {
        Integer teacher = template.getTeacher();
        Integer status = template.getStatus();
        UpdateWrapper<Project> wrapper = new UpdateWrapper<>();
        wrapper.eq("teacher", teacher);
        wrapper.set("status", status);
        projectMapper.update(template, wrapper);
        UpdateWrapper<TeacherDetail> w = new UpdateWrapper<>();
        w.eq("owner", teacher);
        w.set("project_status", status);
        return teacherMapper.update(new TeacherDetail(), w);
    }
}
