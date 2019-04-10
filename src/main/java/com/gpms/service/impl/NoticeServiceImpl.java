package com.gpms.service.impl;

import com.gpms.dao.domain.entity.Notice;
import com.gpms.dao.mapper.NoticeMapper;
import com.gpms.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public List<Notice> getNotices() {
        return noticeMapper.selectList(null);
    }

    @Override
    public Notice getNoticeById(Integer id) {
        return noticeMapper.selectById(id);
    }

    @Override
    public int addNotice(Notice notice) {
        return noticeMapper.insert(notice);
    }
}
