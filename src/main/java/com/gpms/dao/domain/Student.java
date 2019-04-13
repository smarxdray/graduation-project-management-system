package com.gpms.dao.domain;

import com.gpms.dao.domain.entity.StudentDetail;
import com.gpms.dao.domain.entity.User;
import lombok.Data;

@Data
public class Student {
    private User basic;
    private StudentDetail detail;

    public User getBasic() {
        return basic;
    }

    public void setBasic(User basic) {
        this.basic = basic;
    }

    public StudentDetail getDetail() {
        return detail;
    }

    public void setDetail(StudentDetail detail) {
        this.detail = detail;
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
//    Teacher teacher;
//    private Integer statusStudent;
//    private String projectTitle;
//    private String fileUri;
//    private Integer reviewTimes;
//    private Integer college;
//    private Integer major;
//    private Float gpa;
//    private String address;
//    private Boolean allottedDisabled;
//    private Boolean commitDisabled;
//    private Date updateTimeStudent;
//    private Date createTimeStudent;
}