package com.gpms.dao.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.gpms.dao.domain.entity.TeacherDetail;
import com.gpms.dao.domain.entity.User;
import lombok.Data;

import java.util.Date;

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
