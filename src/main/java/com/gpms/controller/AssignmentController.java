package com.gpms.controller;

import com.gpms.dao.domain.entity.StudentDetail;
import com.gpms.service.AssignmentService;
import com.gpms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {
    @Autowired
    AssignmentService assignmentService;

    @PostMapping()
    public Response updateAssignments(@RequestBody Map<String, List<StudentDetail>> assignments) {
        List<StudentDetail> assigned = assignments.get("assigned");
        List<StudentDetail> unassigned = assignments.get("unassigned");
        int lines = assignmentService.setAssignments(assigned, unassigned);
        return Response.ok(lines);
    }
}
