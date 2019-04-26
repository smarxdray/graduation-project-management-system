package com.gpms.controller;

import com.gpms.domain.entity.StudentDetail;
import com.gpms.service.UpdateService;
import com.gpms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ActionController {
    @Autowired
    private UpdateService updateService;

    @PostMapping("/assignments")
    public Response updateAssignments(@RequestBody Map<String, List<StudentDetail>> assignments) {
        List<StudentDetail> assigned = assignments.get("assigned");
        List<StudentDetail> unassigned = assignments.get("unassigned");
        int lines = updateService.setAssignments(assigned, unassigned);
        return Response.ok(lines);
    }

    @PutMapping("/select-project")
    public Response selectProject(@RequestBody Map<String, Object> data) {
        Integer student = (Integer) data.get("student");
        Integer project = (Integer) data.get("project");
        boolean successful = updateService.selectProject(student, project);
        return successful ? Response.ok() : Response.errorMsg("操作失败！");
    }

    @PutMapping("unselect-project")
    public Response unselectProject(@RequestBody Map<String, Object> data) {
        Integer student = (Integer) data.get("student");
        Integer project = (Integer) data.get("project");
        boolean successful = updateService.unselectProject(student, project);
        return successful ? Response.ok() : Response.errorMsg("操作失败！");
    }
}
