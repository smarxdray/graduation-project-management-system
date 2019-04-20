package com.gpms.controller;

import com.gpms.dao.domain.entity.Notice;
import com.gpms.dao.domain.wrapper.NoticeWrapper;
import com.gpms.service.CreateService;
import com.gpms.service.ReadService;
import com.gpms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notices")
public class NoticeController {
    @Autowired
    private ReadService readService;
    @Autowired
    private CreateService createService;
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

//    @MessageMapping("/hello")
//    @SendTo("/topic/greeting")
//    public Response greeting(String greeting) {
//        return Response.ok("Hello," + greeting + "!");
//    }

    @GetMapping({"", "/{id}"})
    public Response getNotices(@PathVariable(required = false) Integer id) {
        // PathVariable: id existing
        if (id != null) {
            Notice notice = readService.getNoticeById(id);
            return notice == null ? Response.errorMsg("获取通知详情失败！")
                    : Response.ok(notice);
        }
        // PathVariable empty
        List<Notice> notices = readService.getNotices();
        return notices == null ? Response.errorMsg("获取通知列表失败！")
                : Response.ok(notices);
    }

    @GetMapping("/users/{id}")
    public Response getNoticesByUserId(@PathVariable(name = "id") Integer userId) {
        List<Notice> notices = readService.getNoticesByUserId(userId);
        return notices == null ? Response.errorMsg("获取通知列表失败！")
                : Response.ok(notices);
    }

    @PostMapping("")
    public Response addNotice(@RequestBody NoticeWrapper noticeWrapper) {
        int lines = createService.addNotice(noticeWrapper.getNotice(), noticeWrapper.getPrivateDetails());
        if (lines <= 0) return Response.errorMsg("发布失败！");
        else {
            pop(noticeWrapper);
            return Response.ok();
        }
    }

    private void pop(NoticeWrapper noticeWrapper) {

        this.messagingTemplate.convertAndSend("/broadcast/notices", noticeWrapper.getNotice());

    }
}