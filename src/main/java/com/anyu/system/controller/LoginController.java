package com.anyu.system.controller;

import com.anyu.system.common.api.CommonResult;
import com.anyu.system.common.util.CommonConstant;
import com.anyu.system.service.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class LoginController implements CommonConstant {
    @Resource
    private AdminService adminService;


//    @GetMapping("/login")
//    public String getLoginPage() {
//        return "login";
//    }
    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 结果
     */
    @PostMapping("/login")
    public String login(String username, String password, Model model, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            model.addAttribute("result",CommonResult.validateFailed("账号密码不能为空！"));
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            return "login";
        }
        Map<String, Object> login = adminService.login(username, password);

        if (login.containsKey("ticket")) {
            //给客户端发送登录cookie
            Cookie cookie = new Cookie("ticket", login.get("ticket").toString());
            cookie.setPath(request.getContextPath());
            cookie.setMaxAge(ADMIN_ALIVE_TIME);
            response.addCookie(cookie);
            model.addAttribute("result", CommonResult.success("登录成功！"));
            return "redirect:/index";
        }
        if (login.containsKey("msg")) {
            model.addAttribute("result", CommonResult.validateFailed(login.get("msg").toString()));
        }
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("result", CommonResult.validateFailed("登录失败！"));
        return "login";

    }
}
