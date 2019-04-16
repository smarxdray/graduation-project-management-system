package com.gpms.dao.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("student")
public class StudentDetail {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.id
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    @TableField("`id`")
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.owner
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Integer owner;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.teacher
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Integer teacher;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.status
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.project_title
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Integer project;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.file_uri
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private String fileDir;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.review_times
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Integer reviewTimes;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.college
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Integer college;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.major
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Integer major;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.gpa
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Float gpa;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.address
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.allotted_disabled
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Boolean allottedDisabled;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.commit_disabled
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Boolean commitDisabled;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.update_time
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.create_time
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public StudentDetail(Integer id, Integer owner, Integer teacher, Integer status, Integer project, String fileDir, Integer reviewTimes, Integer college, Integer major, Float gpa, String address, Boolean allottedDisabled, Boolean commitDisabled, Date updateTime, Date createTime) {
        this.id = id;
        this.owner = owner;
        this.teacher = teacher;
        this.status = status;
        this.project = project;
        this.fileDir = fileDir;
        this.reviewTimes = reviewTimes;
        this.college = college;
        this.major = major;
        this.gpa = gpa;
        this.address = address;
        this.allottedDisabled = allottedDisabled;
        this.commitDisabled = commitDisabled;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public StudentDetail() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.id
     *
     * @return the value of student.id
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.id
     *
     * @param id the value for student.id
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.owner
     *
     * @return the value of student.owner
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Integer getOwner() {
        return owner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.owner
     *
     * @param owner the value for student.owner
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.teacher
     *
     * @return the value of student.teacher
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Integer getTeacher() {
        return teacher;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.teacher
     *
     * @param teacher the value for student.teacher
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.status
     *
     * @return the value of student.status
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.status
     *
     * @param status the value for student.status
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.project_title
     *
     * @return the value of student.project_title
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Integer getProjectTitle() {
        return project;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.project_title
     *
     * @param projectTitle the value for student.project_title
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setProjectTitle(Integer projectTitle) {
        this.project = projectTitle == null ? null : project;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.file_uri
     *
     * @return the value of student.file_uri
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public String getFileDir() {
        return fileDir;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.file_uri
     *
     * @param fileDir the value for student.file_uri
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setFileDir(String fileDir) {
        this.fileDir = fileDir == null ? null : fileDir.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.review_times
     *
     * @return the value of student.review_times
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Integer getReviewTimes() {
        return reviewTimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.review_times
     *
     * @param reviewTimes the value for student.review_times
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setReviewTimes(Integer reviewTimes) {
        this.reviewTimes = reviewTimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.college
     *
     * @return the value of student.college
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Integer getCollege() {
        return college;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.college
     *
     * @param college the value for student.college
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setCollege(Integer college) {
        this.college = college;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.major
     *
     * @return the value of student.major
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Integer getMajor() {
        return major;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.major
     *
     * @param major the value for student.major
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setMajor(Integer major) {
        this.major = major;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.gpa
     *
     * @return the value of student.gpa
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Float getGpa() {
        return gpa;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.gpa
     *
     * @param gpa the value for student.gpa
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.address
     *
     * @return the value of student.address
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.address
     *
     * @param address the value for student.address
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.allotted_disabled
     *
     * @return the value of student.allotted_disabled
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Boolean getAllottedDisabled() {
        return allottedDisabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.allotted_disabled
     *
     * @param allottedDisabled the value for student.allotted_disabled
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setAllottedDisabled(Boolean allottedDisabled) {
        this.allottedDisabled = allottedDisabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.commit_disabled
     *
     * @return the value of student.commit_disabled
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Boolean getCommitDisabled() {
        return commitDisabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.commit_disabled
     *
     * @param commitDisabled the value for student.commit_disabled
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setCommitDisabled(Boolean commitDisabled) {
        this.commitDisabled = commitDisabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.update_time
     *
     * @return the value of student.update_time
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.update_time
     *
     * @param updateTime the value for student.update_time
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.create_time
     *
     * @return the value of student.create_time
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.create_time
     *
     * @param createTime the value for student.create_time
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}