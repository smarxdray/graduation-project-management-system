package com.gpms.service.impl;

import com.gpms.dao.domain.entity.Notice;
import com.gpms.dao.domain.entity.PrivateNotice;
import com.gpms.dao.mapper.NoticeMapper;
import com.gpms.dao.mapper.PrivateNoticeMapper;
import com.gpms.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeMapper noticeMapper;
    @Autowired
    PrivateNoticeMapper privateNoticeMapper;

    @Override
    public List<Notice> getNotices() {
        return noticeMapper.selectList(null);
    }

    @Override
    public Notice getNoticeById(Integer id) {
        return noticeMapper.selectById(id);
    }

    @Override
    public List<Notice> getNoticesByUserId(Integer userId) {
        return noticeMapper.getNoticesByUserId(userId);
    }

    @Override
    @Transactional
    public int addNotice(Notice notice, List<PrivateNotice> privateNotices) {
        int lines = noticeMapper.insert(notice);
        if (lines > 0) {
            if (privateNotices != null) {
                int ln = 0;
                for (PrivateNotice p : privateNotices) {
                    p.setOwner(notice.getId());
                    ln += privateNoticeMapper.insert(p);
                }
                return ln == privateNotices.size() ? lines : -1;
            } else return -1;
        } else return lines;
    }
}
