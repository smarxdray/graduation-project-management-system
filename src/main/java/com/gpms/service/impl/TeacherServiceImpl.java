package com.gpms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gpms.dao.domain.Teacher;
import com.gpms.dao.domain.entity.Project;
import com.gpms.dao.domain.entity.TeacherDetail;
import com.gpms.dao.mapper.ProjectMapper;
import com.gpms.dao.mapper.TeacherMapper;
import com.gpms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    ProjectMapper projectMapper;

    @Override
    public List<Teacher> getTeachersByMajor(Integer majorId) {
        return teacherMapper.selectTeachersByMajor(majorId);
    }

    @Override
    public List<Teacher> getTeachers(String name, Integer college, Integer major, Integer projectStatus) {
        return teacherMapper.selectTeachers(name, college, major, projectStatus);
    }

    @Override
    public TeacherDetail getTeacherDetailByOwner(Integer owner) {
        QueryWrapper<TeacherDetail> wrapper = new QueryWrapper<>();
        wrapper.eq("owner", owner);
        return teacherMapper.selectOne(wrapper);
    }

    @Override
    public int insertTeacherDetail(TeacherDetail detail) {
        return teacherMapper.insert(detail);
    }

    @Override
    public int updateTeacherDetailByOwner(TeacherDetail detail) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("owner", detail.getOwner());
        return teacherMapper.update(detail, wrapper);
    }

    @Override
    @Transactional
    public int addProjects(List<Project> projects) {
        if (projects == null || projects.size() == 0) return 0;
        Integer teacher = projects.get(0).getTeacher();
        Integer status = projects.get(0).getStatus();
        int lines = 0;
        for (Project p : projects) {
            int ln = projectMapper.updateById(p);
            if (ln <= 0) {
                ln = projectMapper.insert(p);
            }
            lines += ln;
        }
        UpdateWrapper<TeacherDetail> w = new UpdateWrapper<>();
        w.eq("owner", teacher);
        w.set("project_status", status);
        teacherMapper.update(new TeacherDetail(), w);
        return lines;
    }

    @Override
    public List<Project> getProjectsByTeacher(Integer id) {
        QueryWrapper<Project> wrapper = new QueryWrapper<>();
        wrapper.eq("teacher", id);
        return projectMapper.selectList(wrapper);
    }

    @Override
    public List<Teacher> getTeachersHavingProjects(Integer projectStatus) {
        return teacherMapper.selectTeachersHavingProjects(projectStatus);
    }
}
