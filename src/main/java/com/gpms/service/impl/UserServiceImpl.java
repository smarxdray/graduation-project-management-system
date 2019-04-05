package com.gpms.service.impl;

import com.gpms.dao.domain.User;
import com.gpms.dao.mapper.UserMapper;
import com.gpms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryUsers() {
        return userMapper.selectList(null);
    }

}
