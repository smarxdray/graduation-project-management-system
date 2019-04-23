package com.gpms.dao.domain;

import com.gpms.dao.domain.entity.Notice;
import com.gpms.dao.domain.entity.PrivateNotice;

public class FullNotice {
    Notice basic;
    PrivateNotice detail;

    public Notice getBasic() {
        return basic;
    }

    public void setBasic(Notice basic) {
        this.basic = basic;
    }

    public PrivateNotice getDetail() {
        return detail;
    }

    public void setDetail(PrivateNotice detail) {
        this.detail = detail;
    }
}
