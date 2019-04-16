package com.gpms.service;

import com.gpms.dao.domain.Teacher;
import com.gpms.dao.domain.entity.Project;
import com.gpms.dao.domain.entity.TeacherDetail;

import java.util.List;

public interface TeacherService {
    List<Teacher> getTeachersByMajor(Integer majorId);
    int insertTeacherDetail(TeacherDetail detail);
    int updateTeacherDetailByOwner(TeacherDetail detail);
    int addProjects(List<Project> projects);
}
