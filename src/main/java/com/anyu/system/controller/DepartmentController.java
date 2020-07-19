package com.anyu.system.controller;

import com.anyu.system.entity.Department;
import com.anyu.system.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Department)表控制层
 *
 * @author Anyu
 * @since 2020-07-18 16:18:27
 */
@Controller
@RequestMapping("/dept")
public class DepartmentController {
    /**
     * 服务对象
     */
    @Resource
    private DepartmentService departmentService;


    /**
     *部门列表
     */
    @GetMapping("/list")
    public String getDepartmentPage() {
        return "pages/department/list";
    }

}