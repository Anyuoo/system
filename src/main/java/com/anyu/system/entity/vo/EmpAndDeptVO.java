package com.anyu.system.entity.vo;

import com.anyu.system.entity.Department;
import com.anyu.system.entity.Employee;

public class EmpAndDeptVO {
    private Employee employee;
    private Department department;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
