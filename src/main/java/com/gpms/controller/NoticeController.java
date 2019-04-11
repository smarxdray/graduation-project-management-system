package com.gpms.controller;

import com.gpms.dao.domain.entity.Notice;
import com.gpms.dao.domain.wrapper.NoticeWrapper;
import com.gpms.service.NoticeService;
import com.gpms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notices")
public class NoticeController {
    @Autowired
    NoticeService noticeService;
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

//    @MessageMapping("/hello")
//    @SendTo("/topic/greeting")
//    public Response greeting(String greeting) {
//        return Response.ok("Hello," + greeting + "!");
//    }

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
    public Response addNotice(@RequestBody NoticeWrapper noticeWrapper) {
        int lines = noticeService.addNotice(noticeWrapper.getNotice(), noticeWrapper.getPrivateDetails());
        if (lines <= 0) return Response.errorMsg("发布失败！");
        else {
            this.messagingTemplate.convertAndSend("/broadcast/notices", "新的通知！");
            return Response.ok();
        }
    }
}
