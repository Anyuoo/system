package com.anyu.system.controller;

import com.anyu.system.entity.Admin;
import com.anyu.system.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Admin)表控制层
 *
 * @author Anyu
 * @since 2020-07-18 19:47:36
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public Admin selectOne(@PathVariable("id") Integer id) {
        return this.adminService.getById(id);
    }

}