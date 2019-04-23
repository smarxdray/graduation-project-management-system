package com.gpms.controller;

import com.gpms.dao.domain.entity.Project;
import com.gpms.dao.mapper.ProjectMapper;
import com.gpms.service.CreateService;
import com.gpms.service.ReadService;
import com.gpms.service.UpdateService;
import com.gpms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ReadService readService;
    @Autowired
    private CreateService createService;
    @Autowired
    private UpdateService updateService;
    @Autowired
    ProjectMapper projectMapper;

    @GetMapping({"", "/{id}"})
    public Response getProjects(@PathVariable(name = "id", required = false) Integer id,
                                @RequestParam(name = "readable", required = false) Boolean readable,
                                @RequestParam(name = "teacher", required = false) Integer teacherId,
                                @RequestParam(name = "status", required = false) Integer status) {
        if (readable != null) {
            if (readable) {
                List<Map<String, Object>> fullProjects = readService.getReadableProjects();
                return fullProjects == null ? Response.errorMsg("获取课题信息失败！")
                        : Response.ok(fullProjects);
            } else {
                List<Project> projects = readService.getProjects();
                return projects == null ? Response.errorMsg("获取课题列表失败！")
                        : Response.ok(projects);
            }
        } else if (teacherId != null) {
            List<Project> projects = readService.getProjectsByTeacher(teacherId);
            return projects == null ? Response.errorMsg("获取课题列表失败！")
                    : Response.ok(projects);
        } else if (id != null) {
            Project project = readService.getProjectsById(id);
            return project == null ? Response.errorMsg("获取课题失败！")
                    : Response.ok(project);
        } else {
            List<Project> projects = readService.getProjects();
            return projects == null ? Response.errorMsg("获取课题列表失败！")
                    : Response.ok(projects);
        }
    }

    @PostMapping()
    public Response addProjects(@RequestBody List<Project> projects) {
        return createService.addProjects(projects) <=0 ? Response.errorMsg("提交课题失败！")
                : Response.ok();
    }

    @PutMapping()
    public Response updateProjectsByTeacher(@RequestBody Project project) {
        if (project != null) {
            int lines = updateService.updateProjects(project);
            return Response.ok(lines);
        }
        return Response.errorMsg("不可接受的请求！");
    }

    @DeleteMapping("/{id}")
    public Response deleteProject(@PathVariable("id") Integer id) {
        int lines = projectMapper.deleteById(id);
        System.out.println(lines);
        return lines <= 0 ? Response.errorMsg("删除失败！")
                : Response.ok();
    }
}
