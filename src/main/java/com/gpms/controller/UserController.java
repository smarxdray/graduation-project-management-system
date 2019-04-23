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
    public Response getUsers(@RequestParam(name = "token", required = false) String token,
                             @RequestParam(name = Constant.PARAM_TYPE, required = false) String type) {
        List<User> userList = null;
        if (token != null) {
            String code = JWT.decode(token).getAudience().get(0);
            User user = readService.getUserByCode(code);
            List<Role> roles = readService.getRoles();
            Map<String, Object> map = new HashMap<>();
            map.put("user", user);
            map.put("roles", roles);
            return (user == null || roles == null) ? Response.errorMsg("获取用户信息失败！")
                    : Response.ok(map);
        } else if (type != null) {
            switch (type) {
                case Constant.ALL:
                    userList = readService.getUsers();
                    break;
                case Constant.ADMIN:
                    userList = readService.getUsers(Constant.ROLE_ADMIN);
                    break;
                case Constant.TEACHER:
                    userList = readService.getTeachers();
                    break;
                case Constant.STUDENT:
                    userList = readService.getStudents();
                    break;
                default: break;
            }
        } else {
            userList = readService.getUsers();
        }
        return userList == null ? Response.errorMsg("获取列表失败！") : Response.ok(userList);
    }

    @GetMapping("/{id}")
    public Response getUserById(@PathVariable("id") Integer id) {
        User user = readService.getUserById(id);
        return user == null ? Response.errorMsg("获取用户信息失败！")
                : Response.ok(user);
    }

    @GetMapping("/{id}/detail")
    public Response getTeacherDetailByOwner(@PathVariable("id") Integer id) {
        User user = readService.getUserById(id);
        Object detail = null;
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
    public Response getTeachers(@RequestParam(name = "major", required = false) Integer major,
                                @RequestParam(name = "project-status", required = false) Integer projectStatus) {
        if (major != null) {
            List<Teacher> teachers = readService.getTeachersByMajor(major);
            return teachers == null ? Response.errorMsg("获取导师列表失败！")
                    : Response.ok(teachers);
        } else if (projectStatus != null) {
            List<Teacher> teachers = readService.getTeachersHavingProjects(projectStatus);
            return teachers == null ? Response.errorMsg("获取信息失败！")
                    : Response.ok(teachers);
        } else {
            return Response.errorMsg("错误的请求！");
        }
    }

    @PostMapping("/teachers")
    public Response getTeachers(@RequestBody Map<String, Object> query) {
        String name = (String) query.get("name");
        Integer college = (Integer) query.get("college");
        Integer major = (Integer) query.get("major");
        Integer projectStatus = (Integer) query.get("projectStatus");
        List<Teacher> teachers = readService.getTeachers(name, college, major, projectStatus);
        return teachers == null ? Response.errorMsg("获取教师信息失败！")
                : Response.ok(teachers);
    }

    @GetMapping("/students")
    public Response getStudents() {
        return null;
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

    @DeleteMapping()
    public Response deleteUser(@RequestParam(name = "id") Integer id) {
        int lines = deleteService.deleteUserById(id);
        if (lines == 1) return Response.ok();
        else return Response.errorMsg("删除失败！");
    }
}