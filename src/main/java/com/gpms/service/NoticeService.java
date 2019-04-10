package com.gpms.service;

import com.gpms.dao.domain.entity.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> getNotices();
    Notice getNoticeById(Integer id);
    int addNotice(Notice notice);
}
