package com.anyu.system.service.impl;

import com.anyu.system.entity.Employee;
import com.anyu.system.mapper.EmployeeMapper;
import com.anyu.system.service.EmployeeService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * (Employee)表服务实现类
 *
 * @author Anyu
 * @since 2020-07-18 16:18:58
 */
@Service("employeeService")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService {

}