package com.anyu.system.controller;

import com.anyu.system.common.api.CommonResult;
import com.anyu.system.common.util.CommonConstant;
import com.anyu.system.service.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class LoginController implements CommonConstant {
    @Resource
    private AdminService adminService;


    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 结果
     */
    @PostMapping("/login")
    @ResponseBody
    public CommonResult<String> login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return CommonResult.validateFailed("账号密码不能为空！");
        }
        Map<String, Object> login = adminService.login(username, password);

        if (login.containsKey("ticket")) {
            //给客户端发送登录cookie
            Cookie cookie = new Cookie("ticket", login.get("ticket").toString());
            cookie.setPath(request.getContextPath());
            cookie.setMaxAge(ADMIN_ALIVE_TIME);
            response.addCookie(cookie);
            return CommonResult.success("登录成功！");
        }
        if (login.containsKey("msg")) {
            return CommonResult.validateFailed(login.get("msg").toString());
        }

        return CommonResult.validateFailed("登录失败！");

    }
}
