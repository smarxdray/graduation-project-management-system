package com.gpms.controller;

import com.gpms.service.UpdateService;
import com.gpms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OperationController {
    @Autowired
    private UpdateService updateService;

    @PutMapping("/select-project")
    public Response selectProject(@RequestBody Map<String, Object> params) {
        Integer student = (Integer) params.get("student");
        Integer project = (Integer) params.get("project");
        boolean successful = updateService.selectProject(student, project);
        return successful ? Response.ok() : Response.errorMsg("操作失败！");
    }
}
