package com.gpms.service;

import com.gpms.dao.domain.Student;
import com.gpms.dao.domain.Teacher;
import com.gpms.dao.domain.entity.*;
import com.gpms.exception.FileException;

import java.util.List;
import java.util.Map;

public interface ReadService {
    List<Map<String, Object>> getReadableProjects();
    List<FileInfo> getFileInfos();
    List<FileInfo> getFileInfosByOwner(Integer owner);
    FileInfo getFileInfoById(Integer id);
    List<College> getColleges();
    List<Major> getMajors();
    List<Major> getMajorsByCollege(Integer college);
    List<Notice> getNotices();
    Notice getNoticeById(Integer id);
    List<Notice> getNoticesByReceiver(Integer receiver);
    List<Project> getProjects();
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
    byte[] read(FileInfo fileInfo) throws FileException;
}
