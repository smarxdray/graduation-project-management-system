package com.gpms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gpms.dao.domain.entity.User;
import com.gpms.dao.mapper.TeacherMapper;
import com.gpms.dao.mapper.UserMapper;
import com.gpms.service.UserService;
import com.gpms.utils.VALUE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        return userMapper.selectList(null);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public List<User> getTeachers() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(VALUE.PARAM_ROLE, VALUE.ROLE_TEACHER);
        return userMapper.selectList(queryWrapper);
    }

    @Override
    public List<User> getStudents() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(VALUE.PARAM_ROLE,  VALUE.ROLE_STUDENT);
        return userMapper.selectList(queryWrapper);
    }
}
