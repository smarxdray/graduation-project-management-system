package com.gpms.controller;

import com.gpms.dao.domain.entity.User;
import com.gpms.service.UserService;
import com.gpms.utils.Constant;
import com.gpms.utils.Response;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

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

    @GetMapping(value = "")
    public Response getUsers(
            @RequestParam(Constant.PARAM_TYPE) String type) {
        List<User> userList = null;
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
        if (userList == null) return Response.errorMsg("获取列表失败！");
        else return Response.ok(userList);
    }

    @PostMapping(value = "")
    public Response addUser(@RequestBody User user) {
        int lines = userService.addUser(user);
        if (lines == 1) return Response.ok();
        else return Response.errorMsg("添加失败！");
    }

    @PutMapping(value = "")
    public Response updateUser(@RequestBody User user) {
        int lines = userService.updateUser(user);
        if (lines == 1) return Response.ok();
        else  return Response.errorMsg("设置失败！");
    }

    @DeleteMapping(value = "")
    public Response deleteUser(@RequestParam(name = "id") Integer id) {
        int lines = userService.deleteUserById(id);
        if (lines == 1) return Response.ok();
        else return Response.errorMsg("删除失败！");
    }
}