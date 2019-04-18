package com.gpms.controller;

import com.gpms.service.OperationService;
import com.gpms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OperationController {
    @Autowired
    OperationService operationService;

    @PutMapping("/select-project")
    public Response selectProject(@RequestBody Map<String, Object> params) {
        Integer student = (Integer) params.get("student");
        Integer project = (Integer) params.get("project");
        boolean successful = operationService.selectProject(student, project);
        return successful ? Response.ok() : Response.errorMsg("操作失败！");
    }
}
