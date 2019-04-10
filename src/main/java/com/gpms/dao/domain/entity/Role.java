package com.gpms.dao.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("role")
public class Role {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.id
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    @TableField("`id`")
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.name
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.desc
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    @TableField("`desc`")
    private String desc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.type
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.status
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    @TableField("`status`")
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.update_time
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.create_time
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Role(Integer id, String name, String desc, Integer type, Integer status, Date updateTime, Date createTime) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.type = type;
        this.status = status;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Role() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.id
     *
     * @return the value of role.id
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.id
     *
     * @param id the value for role.id
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.name
     *
     * @return the value of role.name
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.name
     *
     * @param name the value for role.name
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.desc
     *
     * @return the value of role.desc
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.desc
     *
     * @param desc the value for role.desc
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.type
     *
     * @return the value of role.type
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.type
     *
     * @param type the value for role.type
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.status
     *
     * @return the value of role.status
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.status
     *
     * @param status the value for role.status
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.update_time
     *
     * @return the value of role.update_time
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.update_time
     *
     * @param updateTime the value for role.update_time
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.create_time
     *
     * @return the value of role.create_time
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.create_time
     *
     * @param createTime the value for role.create_time
     *
     * @mbg.generated Fri Apr 05 15:17:56 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}