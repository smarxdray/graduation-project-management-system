package com.gpms.dao.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectDTO {
    private Integer id;
    private Integer teacher;
    private String teacherName;
    private Integer reviewer;
    private String reviewerName;
    private String title;
    private String content;
    private Integer status;
    private Integer student;
    private String studentName;
    private Integer college;
    private Date updateTime;
    private Date createTime;
}
