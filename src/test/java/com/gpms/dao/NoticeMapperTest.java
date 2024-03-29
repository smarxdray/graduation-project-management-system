package com.gpms.dao;

import com.gpms.BaseTest;
import com.gpms.domain.entity.Notice;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NoticeMapperTest extends BaseTest {
    @Autowired
    NoticeMapper noticeMapper;

    @Test
    public void getNoticesByUserId() {
        List<Notice> notices = noticeMapper.getNoticesByReceiver(22);
        System.out.println(notices.size());
    }
}
