package com.anyu.system.controller;

import com.anyu.system.common.api.CommonResult;
import com.anyu.system.common.util.CommonConstant;
import com.anyu.system.entity.Department;
import com.anyu.system.entity.Employee;
import com.anyu.system.entity.vo.EmpAndDeptVO;
import com.anyu.system.service.DepartmentService;
import com.anyu.system.service.EmployeeService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.AnnotationUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * (Employee)表控制层
 *
 * @author Anyu
 * @since 2020-07-18 16:18:58
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController implements CommonConstant {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeService employeeService;
    @Resource
    private DepartmentService departmentService;

    /**
     * 员工列表
     */
    @GetMapping("/list")
    public String getEmployeeListPage(Page<EmpAndDeptVO> page, Model model) {
        page.setSize(20);
        listEmployee(page, null, null, EmplStatus.SERVICE.getCode());
        model.addAttribute("page", page);
        return "pages/employee/list";
    }


    @GetMapping("/search")
    public CommonResult searchEmployee(Page<EmpAndDeptVO> page, String num, String name, Model model) {
        page.setSize(20);
        listEmployee(page, num, name, EmplStatus.SERVICE.getCode());
        return CommonResult.success(page);
    }

    /**
     * 按条件分页查询
     *
     * @param page   分页对象
     * @param num    id
     * @param name   员工姓名
     * @param status 员工状态
     */
    private void listEmployee(Page<EmpAndDeptVO> page, String num, String name, int status) {
        Page<Employee> pageOfEmp = new Page<>();
        pageOfEmp.setCurrent(page.getCurrent());
        pageOfEmp.setSize(page.getSize());
        employeeService.pageEmployeeByCondition(pageOfEmp, num, name, status);
        ArrayList<EmpAndDeptVO> list = new ArrayList<>((int) pageOfEmp.getSize());
        pageOfEmp.getRecords().forEach(employee -> {
            EmpAndDeptVO vo = new EmpAndDeptVO();
            vo.setEmployee(employee);
            Department department = departmentService.getById(employee.getDeptId());
            if (department != null) {
                vo.setDepartment(department);
                list.add(vo);
            }
        });
        page.setRecords(list);
    }

    /**
     * 离职员工列表
     */
    @GetMapping("/del")
    public String getDeleteEmployeePage(Page<EmpAndDeptVO> page, Model model) {
        page.setSize(20);
        listEmployee(page, null, null, EmplStatus.DIMISSION.getCode());
        model.addAttribute("page", page);
        return "pages/employee/del";
    }


    @GetMapping("/edit")
    public String getEditEmployeePage() {
        return "pages/employee/edit";
    }


    /**
     * 员工添加页面
     */
    @GetMapping("/add")
    public String getAddEmployeePage() {
        return "pages/employee/add";
    }

    /**
     * 员工添加
     *
     * @param employee
     */
    @PostMapping("/add")
    @ResponseBody
    public CommonResult addEmployee(Employee employee) {

        if (employee == null) {
            return CommonResult.validateFailed("数据校验失败");
        }
        if (departmentService.getById(employee.getDeptId()) == null) {
            return CommonResult.validateFailed("部门不存在！");
        }
        if (employeeService.save(employee)) {
            return CommonResult.success("添加成功！");
        }
        return CommonResult.failed("添加失败");
    }

    /**
     * 员工修改
     *
     * @param employee
     * @param deptName
     * @return
     */
    @PutMapping("/edit")
    @ResponseBody
    public CommonResult editEmployee(Employee employee, String deptName) {
        System.out.println(employee + deptName);
        Department department = departmentService.getByName(deptName);
        if (department == null) {
            return CommonResult.validateFailed("部门不存在");
        }
        employee.setDeptId(department.getId());
        if (employeeService.updateById(employee)) {
            return CommonResult.success("修改成功");
        }
        return CommonResult.failed("修改失败");
    }

    /**
     * 员工复工
     *
     * @param id
     * @return
     */
    @PutMapping("/renew")
    @ResponseBody
    public CommonResult renewStatus(Integer id) {
        if (id == null) {
            return CommonResult.validateFailed("id不存在");
        }
        if (employeeService.updateStatusById(id,EmplStatus.SERVICE.getCode())) {
            return CommonResult.success("更改成功");
        }
        return CommonResult.failed("更改失败");
    }

    @DeleteMapping("/del")
    @ResponseBody
    public CommonResult delEmployee(Integer id) {
        if (id == 0) {
            return CommonResult.validateFailed("参数不合法");
        }
        if (employeeService.updateStatusById(id,EmplStatus.DIMISSION.getCode())) {
            return CommonResult.success("删除成功");
        }
        return CommonResult.failed("删除失败");
    }
}
