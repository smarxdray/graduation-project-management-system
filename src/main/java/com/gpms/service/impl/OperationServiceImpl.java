package com.gpms.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gpms.dao.domain.entity.Project;
import com.gpms.dao.domain.entity.StudentDetail;
import com.gpms.dao.mapper.ProjectMapper;
import com.gpms.dao.mapper.StudentMapper;
import com.gpms.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationServiceImpl implements OperationService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    ProjectMapper projectMapper;

    @Override
    public boolean selectProject(Integer student, Integer project) {
        UpdateWrapper<StudentDetail> ws = new UpdateWrapper<>();
        ws.eq("owner", student);
        ws.set("project", project);
        int lines = studentMapper.update(new StudentDetail(), ws);
        UpdateWrapper<Project> wp = new UpdateWrapper<>();
        wp.eq("id", project);
        wp.set("student", student);
        wp.set("status", 111);
        lines += projectMapper.update(new Project(), wp);
        return lines == 2;
    }
}
