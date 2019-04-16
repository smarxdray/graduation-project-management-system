package com.gpms.controller;

import com.gpms.dao.domain.Teacher;
import com.gpms.dao.domain.entity.Project;
import com.gpms.service.TeacherService;
import com.gpms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    TeacherService teacherService;

    @PostMapping()
    public Response addProjects(@RequestBody Map<String, List<Project>> projectMap) {
        List<Project> projects = projectMap.get("projects");
        return teacherService.addProjects(projects) <=0 ? Response.errorMsg("提交课题失败！")
                : Response.ok();
    }
}
