package com.anyu.system.controller;

import com.anyu.system.entity.Employee;
import com.anyu.system.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Employee)表控制层
 *
 * @author Anyu
 * @since 2020-07-18 16:18:58
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeService employeeService;

    /**
     * 员工列表
     */
    @GetMapping("/list")
    public String getEmployeeListPage() {
        return "pages/employee/list";
    }

    /**
     * 离职员工列表
     */
    @GetMapping("/del")
    public String getDeleteEmployeePage() {
        return "pages/employee/del";
    }

    @GetMapping("/edit")
    public String getEditEmployeePage() {
        return "pages/employee/edit";
    }


    @GetMapping("/add")
    public String getAddEmployeePage() {
        return "pages/employee/add";
    }



}
