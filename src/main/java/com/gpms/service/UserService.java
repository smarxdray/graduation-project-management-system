package com.gpms.service;

import com.gpms.dao.domain.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(Integer id);
    List<User> getUsers();
    int addUser(User user);
    int updateUser(User user);
    int deleteUserById(Integer id);
    List<User> getStudents();
    List<User> getTeachers();
}