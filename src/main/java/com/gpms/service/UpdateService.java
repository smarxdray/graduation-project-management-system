package com.gpms.service;

import com.gpms.domain.entity.Project;
import com.gpms.domain.entity.StudentDetail;
import com.gpms.domain.entity.TeacherDetail;
import com.gpms.domain.entity.User;

import java.util.List;

public interface UpdateService {
    int setAssignments(List<StudentDetail> assigned, List<StudentDetail> unassigned);
    boolean selectProject(Integer student, Integer project);
    boolean unselectProject(Integer student, Integer project);
    int updateProjects(Project template);
    int updateStudentDetailByOwner(StudentDetail detail);
    int updateTeacherDetailByOwner(TeacherDetail detail);
    int updateUser(User user);
    int setReviewTimes(Integer owner);
}