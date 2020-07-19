package com.anyu.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chart")
public class ChartController {

    @GetMapping("/employee")
    public String getEmployeeTurnover() {
        return "pages/charts/chart1";
    }

    @GetMapping("/dept")
    public String getNumberOfDepartment() {
        return "pages/charts/chart2";
    }

}
