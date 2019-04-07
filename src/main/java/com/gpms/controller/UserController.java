package com.gpms.controller;

import com.gpms.dao.domain.entity.User;
import com.gpms.service.UserService;
import com.gpms.utils.VALUE;
import com.gpms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public Response getUsers(
            @RequestParam(VALUE.PARAM_TYPE) String type) {
        List<User> userList = null;
        switch (type) {
            case VALUE.ALL:
                userList = userService.getUsers();
                break;
            case VALUE.TEACHER:
                userList = userService.getTeachers();
                break;
            case VALUE.STUDENT:
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