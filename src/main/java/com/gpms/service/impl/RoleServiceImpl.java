package com.gpms.service.impl;

import com.gpms.dao.domain.entity.Role;
import com.gpms.dao.mapper.RoleMapper;
import com.gpms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> getRoles() {
        return roleMapper.selectList(null);
    }
}
