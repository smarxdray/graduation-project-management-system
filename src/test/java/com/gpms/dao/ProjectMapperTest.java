package com.gpms.dao;

import com.gpms.BaseTest;
import com.gpms.domain.dto.ProjectDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProjectMapperTest extends BaseTest {
    @Autowired
    ProjectMapper projectMapper;

    @Test
    public void select() {
        List<ProjectDTO> maps = projectMapper.selectProjects(null, null);
        System.out.println(maps.size());
    }
}
