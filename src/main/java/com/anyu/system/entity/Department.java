package com.anyu.system.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

/**
 * (Department)实体类
 *
 * @author Anyu
 * @since 2020-07-18 16:18:24
 */
@TableName(value = "department", autoResultMap = true)
public class Department implements Serializable {
    private static final long serialVersionUID = -20386261342747771L;

    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private String name;

    @TableField(fill = FieldFill.INSERT)
    private Integer employeeNum;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer status;


    public Integer getId() {
        return id;
    }

    public Department setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Department setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getEmployeeNum() {
        return employeeNum;
    }

    public Department setEmployeeNum(Integer employeeNum) {
        this.employeeNum = employeeNum;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Department setStatus(Integer status) {
        this.status = status;
        return this;
    }

}