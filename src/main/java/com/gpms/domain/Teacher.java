package com.gpms.domain;

import com.gpms.domain.entity.TeacherDetail;
import com.gpms.domain.entity.User;

public class Teacher {
    private User basic;
    private TeacherDetail detail;

    public TeacherDetail getDetail() {
        return detail;
    }

    public void setDetail(TeacherDetail detail) {
        this.detail = detail;
    }

    public User getBasic() {
        return basic;
    }

    public void setBasic(User basic) {
        this.basic = basic;
    }
}
