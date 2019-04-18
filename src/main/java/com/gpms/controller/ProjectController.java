package com.gpms.controller;

import com.gpms.dao.domain.Teacher;
import com.gpms.dao.domain.entity.Project;
import com.gpms.dao.mapper.ProjectMapper;
import com.gpms.service.AdminService;
import com.gpms.service.ProjectService;
import com.gpms.service.TeacherService;
import com.gpms.utils.Response;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    AdminService adminService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    ProjectService projectService;
    @Autowired
    ProjectMapper projectMapper;

    @GetMapping({"", "/{id}"})
    public Response getProjectsByTeacher(@PathVariable(name = "id", required = false) Integer id,
                                         @RequestParam(name = "teacher", required = false) Integer teacherId) {
        if (teacherId != null) {
            List<Project> projects = teacherService.getProjectsByTeacher(teacherId);
            return projects == null ? Response.errorMsg("获取课题列表失败！")
                    : Response.ok(projects);
        } else if (id != null) {
            Project project = projectService.getProjectsById(id);
            return project == null ? Response.errorMsg("获取课题失败！")
                    : Response.ok(project);
        } else {
            List<Project> projects = projectService.getProjects();
            return projects == null ? Response.errorMsg("获取课题列表失败！")
                    : Response.ok(projects);
        }
    }

    @GetMapping("/details")
    public Response getFullProjects() {
        List<Map<String, Object>> fullProjects = adminService.getFullProjects();
        return fullProjects == null ? Response.errorMsg("获取课题信息失败！")
                : Response.ok(fullProjects);
    }

    @PostMapping()
    public Response addProjects(@RequestBody List<Project> projects) {
        return teacherService.addProjects(projects) <=0 ? Response.errorMsg("提交课题失败！")
                : Response.ok();
    }

    @PutMapping()
    public Response updateProjectsByTeacher(@RequestBody Project project) {
        if (project != null) {
            int lines = projectService.updateProjects(project);
            return Response.ok(lines);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Response deleteProject(@PathVariable("id") Integer id) {
        if (id != null) {
            int lines = projectMapper.deleteById(id);
            System.out.println(lines);
            return lines <= 0 ? Response.errorMsg("删除失败！")
                    : Response.ok();
        }
        return Response.errorMsg("不可接受的请求！");
    }
}
