package com.anyu.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * (Employee)实体类
 *
 * @author Anyu
 * @since 2020-07-18 16:18:58
 */
@TableName(value = "employee", autoResultMap = true)
public class Employee implements Serializable {
    private static final long serialVersionUID = 389775167349803267L;

    /**
    * 员工ID
    */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
    * 员工姓名
    */
    private String name;
    /**
    * 员工性别
     * 0-未知；1-男；2-女
    */
    @TableField(fill = FieldFill.INSERT)
    private Integer sex;
    /**
    * 员工年龄
    */
    @TableField(fill = FieldFill.INSERT)
    private Integer age;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 员工部门ID
    */
    private Integer deptId;
    /**
    * 入职时间
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss",iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime entryTime;
    /**
    * 辞职时间
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss",iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime resignTime;
    /**
    * 0-任职；1-离职；2-信息删除
    */
    @TableField(fill = FieldFill.INSERT)
    private Integer status;


    public Integer getId() {
        return id;
    }

    public Employee setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public Employee setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Employee setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public Employee setDeptId(Integer deptId) {
        this.deptId = deptId;
        return this;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public Employee setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
        return this;
    }

    public LocalDateTime getResignTime() {
        return resignTime;
    }

    public Employee setResignTime(LocalDateTime resignTime) {
        this.resignTime = resignTime;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Employee setStatus(Integer status) {
        this.status = status;
        return this;

    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", deptId=" + deptId +
                ", entryTime=" + entryTime +
                ", resignTime=" + resignTime +
                ", status=" + status +
                '}';
    }

}