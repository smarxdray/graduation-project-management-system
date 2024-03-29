package com.gpms.service;

import com.gpms.domain.entity.*;
import com.gpms.exception.FileException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CreateService {
    String write(String personalDir, MultipartFile file, int idx) throws FileException;
    int write(List<MultipartFile> files, Integer userId)  throws FileException;
    int addNotice(Notice notice, List<PrivateNotice> privateNotices);
    int addStudentDetail(StudentDetail detail);
    int addTeacherDetail(TeacherDetail detail);
    int addProjects(List<Project> projects);
    int addUser(User user);
    int addComment(Comment comment);
}
