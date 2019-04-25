package com.gpms.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gpms.dao.domain.dto.ProjectDTO;
import com.gpms.dao.domain.entity.Project;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface ProjectMapper extends BaseMapper<Project> {
    ProjectDTO selectProject(@Param("id") Integer id);
    List<ProjectDTO> selectProjects(@Param("status") Integer status,
                                    @Param("teacher") Integer teacher);
}
