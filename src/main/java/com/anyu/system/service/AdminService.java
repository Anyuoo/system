package com.anyu.system.service;

import com.anyu.system.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * (Admin)表服务接口
 *
 * @author Anyu
 * @since 2020-07-18 19:47:36
 */
public interface AdminService extends IService<Admin> {

    Map<String,Object> login(String username, String password);

    Map<String,Object> register(String username, String password);

    Admin getByName(String name);
}