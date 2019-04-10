package com.gpms.controller;

import com.gpms.dao.domain.Student;
import com.gpms.service.StudentService;
import com.gpms.utils.Response;
import com.gpms.utils.VALUE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("")
    public Response getStudents(@RequestParam(VALUE.PARAM_ALLOTTED) Integer allotted) {
        List<Student> studentList = null;
        switch(allotted) {
            case 0:
                studentList = studentService.getStudentNotAllotted();
                break;
                default: break;
        }
        if (studentList == null) return Response.errorMsg("获取列表失败！");
        else return Response.ok(studentList);
    }
}
