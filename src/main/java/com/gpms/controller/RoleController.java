package com.gpms.controller;

import com.gpms.dao.domain.entity.Role;
import com.gpms.service.impl.RoleServiceImpl;
import com.gpms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RoleServiceImpl roleService;

    @GetMapping("")
    public Response getRoles() {
        List<Role> roleList;
        roleList = roleService.getRoles();
        if (roleList == null) return Response.errorMsg("请求角色列表失败！");
        else return Response.ok(roleList);
    }
}
