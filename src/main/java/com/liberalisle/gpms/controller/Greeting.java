package com.liberalisle.gpms.controller;

import com.liberalisle.gpms.domain.User;
import com.liberalisle.gpms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {
    @Autowired
    private User user;

    @RequestMapping("/greeting/{name}")
    public Object hello(@PathVariable("name") String name) {
        user.setName(name);
        return Response.ok(user);
    }
}
