package com.gpms.controller;

import com.gpms.dao.domain.entity.StudentDetail;
import com.gpms.service.AssignmentService;
import com.gpms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {
    @Autowired
    AssignmentService assignmentService;

    @PostMapping("")
    public Response addAssignment(@RequestBody List<StudentDetail> studentDetails) {
        int line = assignmentService.assignBatchStudents(studentDetails);
        if (line == studentDetails.size()) return Response.ok();
        else return Response.errorMsg("分配失败！");
    }
}
