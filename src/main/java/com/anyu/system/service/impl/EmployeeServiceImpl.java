package com.anyu.system.service.impl;

import com.anyu.system.entity.Employee;
import com.anyu.system.mapper.EmployeeMapper;
import com.anyu.system.service.EmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.support.ManagedArray;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * (Employee)表服务实现类
 *
 * @author Anyu
 * @since 2020-07-18 16:18:58
 */
@Service("employeeService")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService {

    @Override
    public IPage<Employee> pageEmployee(IPage<Employee> page) {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.ne("status", 2);
        return this.page(page, wrapper);
    }

    @Override
    public boolean updateStatusById(Integer id, int status) {
        Employee employee = this.getById(id);
        if (employee == null) {
            return false;
        }
        employee.setStatus(status);
        return  this.updateById(employee);
    }

    @Override
    public IPage<Employee> pageEmployeeByCondition(IPage<Employee> page, String num, String name, int status) {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        HashMap<String, Object> map = new HashMap<>(4);
        if (StringUtils.isNotBlank(num) && NumberUtils.isDigits(num)) {
            map.put("id", Integer.parseInt(num));
        }
        if (StringUtils.isNotBlank(name)) {
            map.put("name", name);
        }
        map.put("status", status);
        wrapper.allEq(map);
        return this.page(page,wrapper);
    }
}