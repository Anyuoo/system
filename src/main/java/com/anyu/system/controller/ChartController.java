package com.anyu.system.controller;

import com.anyu.system.common.util.CommonConstant;
import com.anyu.system.entity.Department;
import com.anyu.system.service.DepartmentService;
import com.anyu.system.service.EmployeeService;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 部门员工分布
     * @return
     */
    @GetMapping("/chart2")
    @ResponseBody
    public List<HashMap<String, Object>> getChart2Data() {

        List<Department> departmentList = departmentService.listDept(DeptStatus.SERVICE.getCode());

        List<HashMap<String, Object>> data = new ArrayList<>( departmentList.size());
        departmentList.forEach(dept->{
            HashMap<String, Object> map = new HashMap<>(2);
            map.put("value", dept.getEmployeeNum());
            map.put("name", dept.getName());
            data.add(map);
        });
        return data;
    }

}
