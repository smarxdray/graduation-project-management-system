package com.gpms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gpms.dao.domain.entity.StudentDetail;
import com.gpms.dao.mapper.StudentMapper;
import com.gpms.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public StudentDetail getStudentDetail(Integer owner) {
        QueryWrapper<StudentDetail> wrapper = new QueryWrapper<>();
        wrapper.eq("owner", owner);
        return studentMapper.selectOne(wrapper);
    }
}
