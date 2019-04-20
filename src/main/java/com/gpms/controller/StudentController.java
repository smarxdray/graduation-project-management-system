package com.gpms.controller;

import com.gpms.dao.domain.Student;
import com.gpms.dao.domain.entity.StudentDetail;
import com.gpms.service.ReadService;
import com.gpms.service.UpdateService;
import com.gpms.utils.Response;
import com.gpms.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private ReadService readService;
    @Autowired
    private UpdateService updateService;

    @GetMapping()
    public Response getStudents(@RequestParam(name = Constant.PARAM_ALLOTTED, required = false) Boolean allotted,
                                @RequestParam(name = "teacher", required = false) Integer teacherId) {
        List<Student> studentList = null;
        if (allotted != null) {
                studentList = readService.getStudentsAllottedOrNot(allotted);
        } else if (teacherId != null) {
            studentList = readService.getStudentsByTeacher(teacherId);
        }
        return studentList == null ? Response.errorMsg("获取列表失败！")
                : Response.ok(studentList);
    }

    @GetMapping("/details")
    public Response getStudentDetails(@RequestParam("teacher") Integer teacherId) {
        List<StudentDetail> studentDetails = null;
        studentDetails = readService.getStudentDetailsByTeacher(teacherId);
        return studentDetails == null ? Response.errorMsg("获取学生详细信息失败！")
                : Response.ok(studentDetails);
    }

    @PutMapping("/project")
    public Response setProject(@RequestParam("student") Integer student,
                               @RequestParam("project") Integer project) {
        if (student != null && project != null) {
            boolean success = updateService.selectProject(student, project);
            return success ? Response.errorMsg("操作失败！")
                    : Response.ok();
        }
        return null;
    }
}
