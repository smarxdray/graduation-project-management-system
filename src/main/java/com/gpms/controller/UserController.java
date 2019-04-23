package com.gpms.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.gpms.annotation.UserLoginToken;
import com.gpms.dao.domain.Student;
import com.gpms.dao.domain.Teacher;
import com.gpms.dao.domain.entity.*;
import com.gpms.service.*;
import com.gpms.utils.Constant;
import com.gpms.utils.Response;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private CreateService createService;
    @Autowired
    private ReadService readService;
    @Autowired
    private UpdateService updateService;
    @Autowired
    private DeleteService deleteService;

//    @MessageMapping("/hello")
//    @SendTo("/topic/greeting")
//    public String greeting(User greeting) {
//        return greeting.toString();
//    }

    @GetMapping()
    public Response getUsers(@RequestParam(name = "token", required = false) String token) {
        if (token != null) {
            String code = JWT.decode(token).getAudience().get(0);
            User user = readService.getUserByCode(code);
            List<Role> roles = readService.getRoles();
            Map<String, Object> map = new HashMap<>();
            map.put("user", user);
            map.put("roles", roles);
            return (user == null || roles == null) ? Response.errorMsg("获取用户信息失败！")
                    : Response.ok(map);
        } else {
            List<User> userList = readService.getUsers();
            return userList == null ? Response.errorMsg("获取列表失败！") : Response.ok(userList);
        }
    }

    @GetMapping("/{id}")
    public Response getUserById(@PathVariable("id") Integer id) {
        User user = readService.getUserById(id);
        return user == null ? Response.errorMsg("获取用户信息失败！")
                : Response.ok(user);
    }

    @GetMapping("/{id}/detail")
    public Response getTeacherDetailByOwner(@PathVariable("id") Integer id) {
        Object detail = null;
        User user = readService.getUserById(id);
        switch (user.getRole()) {
            case 1:
                break;
            case 4:
                detail = readService.getTeacherDetailByOwner(id);
                break;
            case 5:
                detail = readService.getStudentDetail(id);
                break;
        }
        return detail == null ? Response.errorMsg("获取账号详情失败！")
                : Response.ok(detail);
    }

    @GetMapping("/admins")
    public Response getAdmins() {
        return null;
    }

    @GetMapping("/teachers")
    public Response getTeachers(@RequestParam(name = "name", required = false) String name,
                                @RequestParam(name = "college", required = false) Integer college,
                                @RequestParam(name = "major", required = false) Integer major,
                                @RequestParam(name = "project-status", required = false) Integer projectStatus) {
            List<Teacher> teachers = readService.getTeachers(name, college, major, projectStatus);
            return teachers == null ? Response.errorMsg("获取教师信息失败！")
                    : Response.ok(teachers);
    }

    @GetMapping("/teachers/details")
    public Response getTeacherDetails(@RequestParam(name = "owner", required = false) Integer owner) {
        if (owner != null) {
            TeacherDetail teacherDetail = readService.getTeacherDetail(owner);
            return teacherDetail == null ? Response.errorMsg("获取教师详情失败！")
                    : Response.ok(teacherDetail);
        } else {
            return Response.errorMsg("不可接受的请求！");
        }
    }

    @GetMapping("/students")
    public Response getStudents(@RequestParam(name = "assigned", required = false) Boolean assigned,
                                @RequestParam(name = "teacher", required = false) Integer teacherId) {
        List<Student> studentList = null;
        if (assigned != null) {
            studentList = readService.getStudentsAllottedOrNot(assigned);
        } else if (teacherId != null) {
            studentList = readService.getStudentsByTeacher(teacherId);
        }
        return studentList == null ? Response.errorMsg("获取列表失败！")
                : Response.ok(studentList);
    }

    @GetMapping("/students/details")
    public Response getStudentDetails(@RequestParam(name = "teacher", required = false) Integer teacher) {
        List<StudentDetail> studentDetails = readService.getStudentDetailsByTeacher(teacher);
        return studentDetails == null ? Response.errorMsg("获取学生详细信息失败！")
                : Response.ok(studentDetails);
    }

    @PostMapping()
    public Response addUser(@RequestBody User user) {
        int lines = createService.addUser(user);
        if (lines == 1) return Response.ok();
        else return Response.errorMsg("添加失败！");
    }

    @PostMapping("/login")
    public Response login(@RequestBody User user){
        User u =readService.getUserByCode(user.getCode());
        if(u == null){
            return Response.errorMsg("登录失败,用户不存在");
        } else {
            if (!u.getPassword().equals(user.getPassword())){
                return Response.errorMsg("登录失败,密码错误");
            }else if (u.getStatus() == -1) {
                return Response.errorMsg("登录失败,账号被禁用");
            } else{
                String token= JWT.create().withAudience(u.getCode())
                        .sign(Algorithm.HMAC256(user.getPassword()));
                Map<String, String> map = new HashMap<>();
                map.put("token", token);
                return Response.ok(map);
            }
        }
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }

    @PutMapping()
    public Response updateUser(@RequestBody User user) {
        int lines = updateService.updateUser(user);
        if (lines == 1) return Response.ok();
        else  return Response.errorMsg("设置失败！");
    }

    @DeleteMapping("/{id}")
    public Response deleteUser(@PathVariable("id") Integer id) {
        int lines = deleteService.deleteUser(id);
        if (lines == 1) return Response.ok();
        else return Response.errorMsg("删除失败！");
    }
}