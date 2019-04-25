package com.gpms.dao;

import com.gpms.BaseTest;
import com.gpms.dao.domain.dto.ProjectDTO;
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
        List<ProjectDTO> maps = projectMapper.selectProjects(null, null);
        System.out.println(maps.size());
    }
}
