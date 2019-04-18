package com.gpms.dao;

import com.gpms.BaseTest;
import com.gpms.dao.mapper.ProjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class ProjectMapperTest extends BaseTest {
    @Autowired
    ProjectMapper projectMapper;

    @Test
    public void select() {
        List<Map<String, Object>> maps = projectMapper.selectFullProjects();
        System.out.println(maps.size());
        System.out.println(maps.get(0).get("createTime"));
    }
}
