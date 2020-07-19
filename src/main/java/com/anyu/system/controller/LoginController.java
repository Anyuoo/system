package com.anyu.system.controller;

import com.anyu.system.common.api.CommonResult;
import com.anyu.system.service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {
    @Resource
    private AdminService adminService;

    @PostMapping("/login")
    public CommonResult<String> login(String username,String password) {
        adminService.login(username, password);
        return CommonResult.success("1212");
    }
}
