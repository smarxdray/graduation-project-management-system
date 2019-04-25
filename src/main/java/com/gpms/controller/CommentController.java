package com.gpms.controller;

import com.gpms.dao.domain.entity.Comment;
import com.gpms.service.CreateService;
import com.gpms.service.ReadService;
import com.gpms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    ReadService readService;
    @Autowired
    CreateService createService;

    @GetMapping({"", "/{id}"})
    public Response getComment(@PathVariable("id") Integer id,
                               @RequestParam(name = "author", required = false) Integer author,
                               @RequestParam(name = "target", required = false) Integer target) {
        if (id != null) {
            Comment comment = readService.getComment(id);
            return comment == null ? Response.errorMsg("获取失败！")
                    : Response.ok(comment);
        } else {
            List<Comment> comments = readService.getComments(author, target);
            return comments == null ? Response.errorMsg("获取失败！")
                    : Response.ok(comments);
        }
    }

    @PostMapping
    public Response addComment(@RequestBody Comment comment) {
        int lines = createService.addComment(comment);
        return lines == 0 ? Response.errorMsg("添加失败！")
                : Response.ok();
    }
}
