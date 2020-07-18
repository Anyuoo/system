package com.anyu.system.service.impl;

import com.anyu.system.entity.Employee;
import com.anyu.system.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void test() {
        Employee employee = new Employee();
        employee.setName("ls")
                .setAge(14)
                .setDeptId(1)
                .setEmail("2812@qq.com")
                .setSex(1);
        employeeService.save(employee);
    }
}