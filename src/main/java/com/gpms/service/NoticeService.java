package com.gpms.service;

import com.gpms.dao.domain.entity.Notice;
import com.gpms.dao.domain.entity.PrivateNotice;

import java.util.List;

public interface NoticeService {
    List<Notice> getNotices();
    Notice getNoticeById(Integer id);
    int addNotice(Notice notice, List<PrivateNotice> privateNotices);
}
