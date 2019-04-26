package com.gpms.domain.wrapper;

import com.gpms.domain.entity.Notice;
import com.gpms.domain.entity.PrivateNotice;

import java.util.List;

public class NoticeWrapper {
    private Notice notice;
    private List<PrivateNotice> privateDetails;

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    public List<PrivateNotice> getPrivateDetails() {
        return privateDetails;
    }

    public void setPrivateDetails(List<PrivateNotice> privateDetails) {
        this.privateDetails = privateDetails;
    }
}
