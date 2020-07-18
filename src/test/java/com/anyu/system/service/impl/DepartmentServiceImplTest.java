package com.anyu.system.service.impl;

import com.anyu.system.entity.Department;
import com.anyu.system.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceImplTest {

    @Autowired
    private DepartmentService departmentService;

    @Test
    void getById() {
        departmentService.getById(1);
    }

    @Test
    void listDepartments() {
    }

    @Test
    void saveDepartment() {
        Department department = new Department();
        department.setName("后勤")
                .setEmployeeNum(10);

        departmentService.save(department);
    }

    @Test
    void update() {
    }

    @Test
    void removeById() {
    }
}