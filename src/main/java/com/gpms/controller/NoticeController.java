package com.gpms.controller;

import com.gpms.dao.domain.entity.Notice;
import com.gpms.dao.mapper.NoticeMapper;
import com.gpms.service.NoticeService;
import com.gpms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notices")
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @GetMapping({"", "/{id}"})
    public Response getNotices(@PathVariable(required = false) Integer id) {

        if (id == null) {
            List<Notice> notices = noticeService.getNotices();
            return notices == null ? Response.errorMsg("获取通知列表失败！")
                    : Response.ok(notices);
        } else {
            Notice notice = noticeService.getNoticeById(id);
            return notice == null ? Response.errorMsg("获取通知详情失败！")
                    : Response.ok(notice);
        }
    }

    @PostMapping("")
    public Response addNotice(@RequestBody Notice notice) {
        int lines = noticeService.addNotice(notice);
        if (lines == 0) return Response.errorMsg("发布失败！");
        else return Response.ok();
    }
}
