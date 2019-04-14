package com.gpms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gpms.dao.domain.entity.College;
import com.gpms.dao.domain.entity.Major;
import com.gpms.dao.mapper.CollegeMapper;
import com.gpms.dao.mapper.MajorMapper;
import com.gpms.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    CollegeMapper collegeMapper;
    @Autowired
    MajorMapper majorMapper;

    @Override
    public List<College> getColleges() {
        return collegeMapper.selectList(null);
    }

    @Override
    public List<Major> getMajorsByCollege(Integer collegeId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("college", collegeId);
        return majorMapper.selectList(wrapper);
    }
}
