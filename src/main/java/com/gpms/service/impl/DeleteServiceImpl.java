package com.gpms.service.impl;

import com.gpms.dao.mapper.UserMapper;
import com.gpms.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteServiceImpl implements DeleteService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteById(id);
    }
}
