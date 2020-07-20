package com.anyu.system.controller;

import com.anyu.system.common.api.CommonResult;
import com.anyu.system.common.util.CommonConstant;
import com.anyu.system.entity.Department;
import com.anyu.system.service.DepartmentService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class DepartmentController implements CommonConstant {
    /**
     * 服务对象
     */
    @Resource
    private DepartmentService departmentService;


    /**
     * 部门列表
     */
    @GetMapping("/list")
    public String getDepartmentPage(Page<Department> page, Model model) {
        page.setSize(20);
        departmentService.page(page);
        model.addAttribute("page",page);
        return "pages/department/list";
    }


    @GetMapping("add")
    public String getAddPage() {
        return "pages/department/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public CommonResult addDepartment(Department department) {
//        System.out.println(department);
        if (department == null) {
            return CommonResult.validateFailed("数据不合法");
        }
        Department dept = departmentService.getByName(department.getName());
        if ( dept != null && departmentService.updateById(dept)){
            return CommonResult.success("添加人数成功");
        }
        if (departmentService.save(department)) {
            return CommonResult.success("添加成功!");
        }
        return CommonResult.failed("添加失败");
    }

    @GetMapping("edit")
    public String getEditPage() {
        return "pages/department/edit";
    }

    @PutMapping("/edit")
    @ResponseBody
    public CommonResult editDept(Department department) {
        if (department == null) {
            return CommonResult.validateFailed("部门不存在！");
        }
        if (departmentService.updateById(department)) {
            return CommonResult.success("修改成功！");
        }
        return CommonResult.failed("修改失败");
    }

    @DeleteMapping("/del")
    @ResponseBody
    public CommonResult delDept(Integer id) {
        if (id == null) {
            return CommonResult.validateFailed("参数不合法");
        }
        if (departmentService.updateStatusById(id, DeptStatus.ABANDON.getCode())) {
            return CommonResult.success("删除成功");
        }
        return CommonResult.failed("删除失败");
    }
}