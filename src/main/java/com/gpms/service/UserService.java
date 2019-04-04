package com.gpms.service;

import com.gpms.dao.domain.User;

import java.util.List;

public interface UserService {
    List<User> queryUsers();
}