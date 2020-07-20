package com.anyu.system.service.impl;

import com.anyu.system.entity.Department;
import com.anyu.system.mapper.DepartmentMapper;
import com.anyu.system.service.DepartmentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Department)表服务实现类
 *
 * @author Anyu
 * @since 2020-07-18 16:18:26
 */
@Service("departmentService")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper,Department> implements DepartmentService {

    @Override
    public Department getByName(String name) {
        QueryWrapper<Department> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        return this.getOne(wrapper);
    }

    @Override
    public boolean updateStatusById(Integer id, int status) {
        Department department = this.getById(id);
        if (department == null) {
            return false;
        }
        department.setStatus(status);
        return this.updateById(department);
    }

    @Override
    public List<Department> listDept(int status) {
        QueryWrapper<Department> wrapper = new QueryWrapper<>();
        wrapper.eq("status", status);
        return this.list(wrapper);
    }
}