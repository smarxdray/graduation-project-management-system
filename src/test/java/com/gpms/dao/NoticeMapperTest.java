package com.gpms.dao;

import com.gpms.BaseTest;
import com.gpms.dao.domain.entity.Notice;
import com.gpms.dao.mapper.NoticeMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NoticeMapperTest extends BaseTest {
    @Autowired
    NoticeMapper noticeMapper;

    @Test
    public void getNoticesByUserId() {
        List<Notice> notices = noticeMapper.getNoticesByUserId(22);
        System.out.println(notices.size());
    }
}
