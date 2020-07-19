package com.anyu.system.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author Anyu
 * @since 2020-07-18 19:47:36
 */
@TableName(value = "admin", autoResultMap = true)
public class Admin implements Serializable {
    private static final long serialVersionUID = -74665029251938167L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private String name;
    
    private String password;

    private String salt;



    @TableField(fill = FieldFill.INSERT)
    private Integer status;


    public Integer getId() {
        return id;
    }

    public Admin setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Admin setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Admin setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSalt() {
        return salt;
    }

    public Admin setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Admin setStatus(Integer status) {
        this.status = status;
        return this;
    }

}