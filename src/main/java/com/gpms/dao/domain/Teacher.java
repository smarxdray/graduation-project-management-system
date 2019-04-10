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
    //    @TableField("`id`")
//    @TableId(type = IdType.AUTO)
//    private Integer id;
//    private String name;
//    private Byte gender;
//    private String role;
//    private Integer status;
//    private String code;
//    private String phone;
//    private String email;
//    @TableField("`desc`")
//    private String desc;
//    private String avatarUri;
//    private String salt;
//    private String password;
//    private Boolean commentDisabled;
//    private Boolean notifyDisabled;
//    private Date updateTime;
//    private Date createTime;
//
//    private String title;
//    private String college;
//    private String major;
//    private Integer studentNumber;
//    private Integer studentMark;
//    private Boolean acceptDisabled;
//    private Date updateTimeTeacher;
//    private Date createTimeTeacher;
}
