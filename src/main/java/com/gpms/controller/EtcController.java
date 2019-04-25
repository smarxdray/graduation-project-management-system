package com.gpms.controller;

import com.gpms.dao.domain.entity.College;
import com.gpms.dao.domain.entity.Major;
import com.gpms.dao.domain.entity.Role;
import com.gpms.service.ReadService;
import com.gpms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EtcController {
    @Autowired
    private ReadService readService;

    @RequestMapping("/colleges")
    public Response getColleges() {
        List<College> colleges = readService.getColleges();
        return colleges == null ? Response.errorMsg("获取学院列表失败！")
                : Response.ok(colleges);
    }

    @GetMapping("/majors")
    public Response getMajors(@RequestParam(name = "college", required = false) Integer college) {
        List<Major> majors;
        if (college != null) {
            majors =  readService.getMajorsByCollege(college);
        } else {
            majors = readService.getMajors();
        }
        return majors == null ? Response.errorMsg("获取专业列表失败！")
                : Response.ok(majors);
    }

    @GetMapping("/roles")
    public Response getRoles() {
        List<Role> roleList;
        roleList = readService.getRoles();
        if (roleList == null) return Response.errorMsg("请求角色列表失败！");
        else return Response.ok(roleList);
    }

}
