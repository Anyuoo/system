package com.anyu.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping({"/", "index"})
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/welcome")
    public String getWelcomePage() {
        return "pages/wel";
    }
}
