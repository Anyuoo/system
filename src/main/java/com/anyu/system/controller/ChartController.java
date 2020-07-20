package com.anyu.system.controller;

import com.anyu.system.common.util.CommonConstant;
import com.anyu.system.entity.Department;
import com.anyu.system.service.DepartmentService;
import com.anyu.system.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("chart")
public class ChartController implements CommonConstant {

    @Resource
    private EmployeeService employeeService;
    @Resource
    private DepartmentService departmentService;
    @GetMapping("/employee")
    public String getEmployeeTurnover() {
        return "pages/charts/chart1";
    }

    @GetMapping("/dept")
    public String getNumberOfDepartment() {
        return "pages/charts/chart2";
    }

    @GetMapping("/chart1")
    @ResponseBody
    public String getChart1Data() {
        return "";
    }

    @GetMapping("/chart2")
    @ResponseBody
    public HashMap<String, Object> getChart2Data() {
        HashMap<String, Object> data = new HashMap<>();
        List<Department> departmentList = departmentService.listDept(DeptStatus.SERVICE.getCode());
        departmentList.forEach(dept->{
            data.put("value", dept.getEmployeeNum());
            data.put("name", dept.getName());
        });
        return data;
    }

}
