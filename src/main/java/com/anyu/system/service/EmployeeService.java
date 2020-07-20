package com.anyu.system.service;

import com.anyu.system.entity.Employee;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * (Employee)表服务接口
 *
 * @author Anyu
 * @since 2020-07-18 16:18:58
 */
public interface EmployeeService extends IService<Employee> {

    IPage<Employee> pageEmployee(IPage<Employee> page);

    IPage<Employee> pageEmployeeByCondition(IPage<Employee> page,String num,String name, int status);

    boolean updateStatusById(Integer id, int status);
}