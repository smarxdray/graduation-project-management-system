package com.gpms.controller;

import com.gpms.dao.domain.Student;
import com.gpms.dao.domain.entity.StudentDetail;
import com.gpms.service.StudentService;
import com.gpms.utils.Response;
import com.gpms.utils.Constant;
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

    @GetMapping()
    public Response getStudents(@RequestParam(name = Constant.PARAM_ALLOTTED, required = false) Boolean allotted,
                                @RequestParam(name = "teacher", required = false) Integer teacherId) {
        List<Student> studentList = null;
        if (allotted != null) {
                studentList = studentService.getStudentsAllottedOrNot(allotted);
        } else if (teacherId != null) {
            studentList = studentService.getStudentsByTeacher(teacherId);
        }
        return studentList == null ? Response.errorMsg("获取列表失败！")
                : Response.ok(studentList);
    }

    @GetMapping("/details")
    public Response getStudentDetails(@RequestParam("teacher") Integer teacherId) {
        List<StudentDetail> studentDetails = null;
        studentDetails = studentService.getStudentDetailsByTeacher(teacherId);
        return studentDetails == null ? Response.errorMsg("获取学生详细信息失败！")
                : Response.ok(studentDetails);
    }
}
