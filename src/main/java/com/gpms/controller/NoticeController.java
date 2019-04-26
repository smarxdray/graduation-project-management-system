package com.gpms.controller;

import com.gpms.domain.entity.Notice;
import com.gpms.domain.wrapper.NoticeWrapper;
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

    @GetMapping()
    public Response getNotices(@RequestParam(name = "receiver", required = false) Integer receiver) {
        List<Notice> notices;
        if (receiver != null) {
            notices = readService.getNoticesByReceiver(receiver);
        } else {
            notices = readService.getNotices();
        }
        return notices == null ? Response.errorMsg("获取通知列表失败！")
                : Response.ok(notices);
    }

    @GetMapping("/{id}")
    public Response getNoticeById(@PathVariable(required = false) Integer id) {
            Notice notice = readService.getNoticeById(id);
            return notice == null ? Response.errorMsg("获取通知详情失败！")
                    : Response.ok(notice);
    }


    @PostMapping()
    public Response addNotice(@RequestBody NoticeWrapper noticeWrapper) {
        int lines = createService.addNotice(noticeWrapper.getNotice(), noticeWrapper.getPrivateDetails());
        if (lines <= 0) return Response.errorMsg("发布失败！");
        else {
            pop(noticeWrapper.getNotice());
            return Response.ok();
        }
    }

    private void pop(Notice notice) {

        this.messagingTemplate.convertAndSend("/broadcast/notices", notice);

    }
}