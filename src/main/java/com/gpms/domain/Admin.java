package com.gpms.domain;

import com.gpms.domain.entity.AdminDetail;
import com.gpms.domain.entity.User;
import lombok.Data;

@Data
public class Admin {
    private User basic;
    private AdminDetail detail;

    public User getBasic() {
        return basic;
    }

    public void setBasic(User basic) {
        this.basic = basic;
    }

    public AdminDetail getDetail() {
        return detail;
    }

    public void setDetail(AdminDetail detail) {
        this.detail = detail;
    }
}