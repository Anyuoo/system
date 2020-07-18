package com.anyu.system.controller;

import com.anyu.system.entity.Employee;
import com.anyu.system.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Employee)表控制层
 *
 * @author Anyu
 * @since 2020-07-18 16:18:58
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeService employeeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Employee selectOne(Long id) {
        return this.employeeService.getById(id);
    }

}