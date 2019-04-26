package com.gpms.service;

import com.gpms.domain.Student;
import com.gpms.domain.Teacher;
import com.gpms.domain.dto.ProjectDTO;
import com.gpms.domain.entity.*;
import com.gpms.exception.FileException;

import java.util.List;

public interface ReadService {
    Comment getComment(Integer id);
    List<Comment> getComments(Integer author, Integer target);
    ProjectDTO getProject(Integer id);
    List<ProjectDTO> getProjects(Integer status, Integer teacher);
    List<FileInfo> getFileInfos();
    List<FileInfo> getFileInfosByOwner(Integer owner);
    FileInfo getFileInfoById(Integer id);
    List<College> getColleges();
    List<Major> getMajors();
    List<Major> getMajorsByCollege(Integer college);
    List<Notice> getNotices();
    Notice getNoticeById(Integer id);
    List<Notice> getNoticesByReceiver(Integer receiver);
    Project getProjectsById(Integer id);
    List<Role> getRoles();

    List<Student> getStudentsAllottedOrNot(boolean allotted);
    List<Student> getStudentsByTeacher(Integer teacher);
    List getStudentDetailsByTeacher(Integer teacherId);
    List<Teacher> getTeachersByMajor(Integer major);
    List<Teacher> getTeachers(String name, Integer college, Integer major, Integer projectStatus);
    TeacherDetail getTeacherDetailByOwner(Integer owner);
    List<Project> getProjectsByTeacher(Integer id);
    List<Teacher> getTeachersHavingProjects(Integer projectStatus);

    User getUserById(Integer id);
    User getUserByCode(String code);
    TeacherDetail getTeacherDetail(Integer id);
    StudentDetail getStudentDetail(Integer id);
    List<User> getUsers();
    List<User> getStudents();
    List<User> getTeachers();
    List<User> getUsers(Integer role);
    byte[] read(FileInfo fileInfo) throws FileException;
    List<FileInfo> getFileInfos(Integer role);
}
