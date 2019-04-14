package com.gpms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gpms.dao.domain.Teacher;
import com.gpms.dao.domain.entity.TeacherDetail;
import com.gpms.dao.mapper.TeacherMapper;
import com.gpms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<Teacher> getTeachersByMajor(Integer majorId) {
        return teacherMapper.selectTeachersByMajor(majorId);
    }

    @Override
    public int insertTeacherDetail(TeacherDetail detail) {
        return teacherMapper.insert(detail);
    }

    @Override
    public int updateTeacherDetail(TeacherDetail detail) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("owner", detail.getOwner());
        return teacherMapper.update(detail, wrapper);
    }
}
