package com.gpms.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.gpms.annotation.UserLoginToken;
import com.gpms.dao.domain.Student;
import com.gpms.dao.domain.Teacher;
import com.gpms.dao.domain.entity.Role;
import com.gpms.dao.domain.entity.StudentDetail;
import com.gpms.dao.domain.entity.TeacherDetail;
import com.gpms.dao.domain.entity.User;
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

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ResourceService resourceService;

//    @MessageMapping("/hello")
//    @SendTo("/topic/greeting")
//    public String greeting(User greeting) {
//        return greeting.toString();
//    }
    @GetMapping("/{id}")
    public Response getUserById(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        return user == null ? Response.errorMsg("获取用户信息失败！")
                : Response.ok(user);
    }

    @GetMapping()
    public Response getUsers(@RequestParam(name = "token", required = false) String token,
                             @RequestParam(name = Constant.PARAM_TYPE, required = false) String type) {
        List<User> userList = null;
        if (token != null) {
            String code = JWT.decode(token).getAudience().get(0);
            User user = userService.getUserByCode(code);
            List<Role> roles = roleService.getRoles();
            Map<String, Object> map = new HashMap<>();
            map.put("user", user);
            map.put("roles", roles);
            return (user == null || roles == null) ? Response.errorMsg("获取用户信息失败！")
                    : Response.ok(map);
        }
        if (type == null) {
            userList = userService.getUsers();
        } else {
            switch (type) {
                case Constant.ALL:
                    userList = userService.getUsers();
                    break;
                case Constant.TEACHER:
                    userList = userService.getTeachers();
                    break;
                case Constant.STUDENT:
                    userList = userService.getStudents();
                    break;
                default: break;
            }
        }
        if (userList == null) return Response.errorMsg("获取列表失败！");
        else return Response.ok(userList);
    }

    @PostMapping()
    public Response addUser(@RequestBody User user) {
        int lines = userService.addUser(user);
        if (lines == 1) return Response.ok();
        else return Response.errorMsg("添加失败！");
    }

    @PostMapping("/login")
    public Response login(@RequestBody User user){
        User u =userService.getUserByCode(user.getCode());
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
        int lines = userService.updateUser(user);
        if (lines == 1) return Response.ok();
        else  return Response.errorMsg("设置失败！");
    }

    @DeleteMapping()
    public Response deleteUser(@RequestParam(name = "id") Integer id) {
        int lines = userService.deleteUserById(id);
        if (lines == 1) return Response.ok();
        else return Response.errorMsg("删除失败！");
    }

    @GetMapping("/teachers")
    public Response getTeachersByMajor(@RequestParam(name = "major", required = false) Integer majorId,
                                       @RequestParam(name = "project-status", required = false) Integer projectStatus) {
        if (majorId != null) {
            List<Teacher> teachers = teacherService.getTeachersByMajor(majorId);
            return teachers == null ? Response.errorMsg("获取导师列表失败！")
                    : Response.ok(teachers);
        } else if (projectStatus != null) {
            List<Teacher> teachers = teacherService.getTeachersHavingProjects(projectStatus);
            return teachers == null ? Response.errorMsg("获取信息失败！")
                    : Response.ok(teachers);
        } else {
            return Response.errorMsg("错误的请求！");
        }

    }

    @PostMapping("/teachers")
    public Response getTeacherByQuery(@RequestBody Map<String, Object> query) {
        String name = (String) query.get("name");
        System.out.println(name);
        Integer college = (Integer) query.get("college");
        System.out.println(college);
        Integer major = (Integer) query.get("major");
        System.out.println(major);
        Integer projectStatus = (Integer) query.get("projectStatus");
        List<Teacher> teachers = teacherService.getTeachers(name, college, major, projectStatus);
        return teachers == null ? Response.errorMsg("获取教师信息失败！")
                : Response.ok(teachers);
    }

    @GetMapping("/teachers/details")
    public Response getTeacherDetailByOwner(@RequestParam("id") Integer ownerId) {
        TeacherDetail teacherDetail = teacherService.getTeacherDetailByOwner(ownerId);
        return teacherDetail == null ? Response.errorMsg("获取教师详情失败！")
                : Response.ok(teacherDetail);
    }

    @GetMapping("/students/details/{id}")
    public Response getStudentDetailByOwner(@PathVariable("id") Integer owner) {
        StudentDetail detail = resourceService.getStudentDetail(owner);
        return detail == null ? Response.errorMsg("失败！") : Response.ok(detail);
    }
}