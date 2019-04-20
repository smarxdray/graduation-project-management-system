package com.gpms.controller;

import com.gpms.dao.domain.entity.College;
import com.gpms.dao.domain.entity.Major;
import com.gpms.service.ReadService;
import com.gpms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InfoController {
    @Autowired
    private ReadService readService;

    @RequestMapping("/colleges")
    public Response getColleges() {
        List<College> colleges = readService.getColleges();
        return colleges == null ? Response.errorMsg("获取学院列表失败！")
                : Response.ok(colleges);
    }

    @GetMapping("/majors")
    public Response getMajors(@RequestParam(name = "college", required = false) Integer collegeId) {
        List<Major> majors = null;
        if (collegeId != null) {
            majors =  readService.getMajorsByCollege(collegeId);
        } else {
            majors = readService.getMajors();
        }
        return majors == null ? Response.errorMsg("获取专业列表失败！")
                : Response.ok(majors);
    }
}
