package com.anyu.system.service.impl;

import com.anyu.system.entity.Admin;
import com.anyu.system.mapper.AdminMapper;
import com.anyu.system.service.AdminService;
import com.anyu.system.common.util.CommonUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * (Admin)表服务实现类
 *
 * @author Anyu
 * @since 2020-07-18 19:47:36
 */
@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminMapper,Admin> implements AdminService {

    @Override
    public Map<String, Object> login(String username, String password) {

        HashMap<String, Object> map = new HashMap<>(1);
        Admin admin = getByName(username);
        if (admin == null) {
            map.put("msg", "admin不存在！");
            return map;
        }
        password = CommonUtil.md5(password + admin.getSalt());
        if (!password.equals(admin.getPassword())) {
            map.put("msg", "密码错误！");
            return map;
        }
        //生成随机登录cookie值
        String ticket = CommonUtil.generateUUIDString();
        map.put("ticket", ticket);
        return map;
    }

    @Override
    public Map<String, Object> register(String username, String password) {
        HashMap<String, Object> map = new HashMap<>(1);
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("name", username);
        if (hasAdmin(wrapper)) {
            map.put("msg", "admin 已经存在");
            return map;
        }
        //
        String salt = CommonUtil.generateUUIDString().substring(0, 6);
        Admin admin = new Admin();
        admin.setName(username)
                .setPassword(CommonUtil.md5(password + salt))
                .setSalt(salt);
        if (!this.save(admin)) {
            map.put("msg", "添加admin出错");
        }
        return map;
    }

    @Override
    public Admin getByName(String name) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        return this.getOne(wrapper);
    }

    private boolean hasAdmin(QueryWrapper<Admin> wrapper) {
        return this.getOne(wrapper) != null;
    }
}