package com.gpms.service;

import com.gpms.dao.domain.Teacher;
import com.gpms.dao.domain.entity.Project;
import com.gpms.dao.domain.entity.TeacherDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherService {
    List<Teacher> getTeachersByMajor(Integer majorId);
    List<Teacher> getTeachers(String name, Integer college, Integer major, Integer projectStatus);
    TeacherDetail getTeacherDetailByOwner(Integer owner);
    int insertTeacherDetail(TeacherDetail detail);
    int updateTeacherDetailByOwner(TeacherDetail detail);
    int addProjects(List<Project> projects);
    List<Project> getProjectsByTeacher(Integer id);
    List<Teacher> getTeachersHavingProjects(Integer projectStatus);
}
