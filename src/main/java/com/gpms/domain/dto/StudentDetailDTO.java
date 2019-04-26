package com.gpms.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StudentDetailDTO {
    private Integer id;
    private Integer owner;
    private Integer teacher;
    private String teacherName;
    private Integer status;
    private Integer project;
    private String projectTitle;
    private String fileDir;
    private Integer reviewTimes;
    private Integer college;
    private Integer major;
    private Float gpa;
    private String address;
    private Boolean allottedDisabled;
    private Boolean commitDisabled;
    private Date updateTime;
    private Date createTime;
}
