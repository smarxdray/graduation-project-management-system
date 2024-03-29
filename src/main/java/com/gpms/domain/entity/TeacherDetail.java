package com.gpms.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("teacher")
public class TeacherDetail {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.id
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    @TableField("`id`")
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.owner
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Integer owner;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.title
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Integer title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.college
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Integer college;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.major
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Integer major;

    private Integer projectStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.student_number
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Integer studentNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.student_mark
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Integer studentMark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.accept_disabled
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Boolean acceptDisabled;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.update_time
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.create_time
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public TeacherDetail(Integer id, Integer owner, Integer title, Integer college, Integer major, Integer projectStatus, Integer studentNumber, Integer studentMark, Boolean acceptDisabled, Date updateTime, Date createTime) {
        this.id = id;
        this.owner = owner;
        this.title = title;
        this.college = college;
        this.major = major;
        this.projectStatus = projectStatus;
        this.studentNumber = studentNumber;
        this.studentMark = studentMark;
        this.acceptDisabled = acceptDisabled;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public TeacherDetail() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.id
     *
     * @return the value of teacher.id
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.id
     *
     * @param id the value for teacher.id
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.owner
     *
     * @return the value of teacher.owner
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Integer getOwner() {
        return owner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.owner
     *
     * @param owner the value for teacher.owner
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.title
     *
     * @return the value of teacher.title
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Integer getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.title
     *
     * @param title the value for teacher.title
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setTitle(Integer title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.college
     *
     * @return the value of teacher.college
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Integer getCollege() {
        return college;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.college
     *
     * @param college the value for teacher.college
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setCollege(Integer college) {
        this.college = college;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.major
     *
     * @return the value of teacher.major
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Integer getMajor() {
        return major;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.major
     *
     * @param major the value for teacher.major
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setMajor(Integer major) {
        this.major = major;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.student_number
     *
     * @return the value of teacher.student_number
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Integer getStudentNumber() {
        return studentNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.student_number
     *
     * @param studentNumber the value for teacher.student_number
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.student_mark
     *
     * @return the value of teacher.student_mark
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Integer getStudentMark() {
        return studentMark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.student_mark
     *
     * @param studentMark the value for teacher.student_mark
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setStudentMark(Integer studentMark) {
        this.studentMark = studentMark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.accept_disabled
     *
     * @return the value of teacher.accept_disabled
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Boolean getAcceptDisabled() {
        return acceptDisabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.accept_disabled
     *
     * @param acceptDisabled the value for teacher.accept_disabled
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setAcceptDisabled(Boolean acceptDisabled) {
        this.acceptDisabled = acceptDisabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.update_time
     *
     * @return the value of teacher.update_time
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.update_time
     *
     * @param updateTime the value for teacher.update_time
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.create_time
     *
     * @return the value of teacher.create_time
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.create_time
     *
     * @param createTime the value for teacher.create_time
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Integer projectStatus) {
        this.projectStatus = projectStatus;
    }
}