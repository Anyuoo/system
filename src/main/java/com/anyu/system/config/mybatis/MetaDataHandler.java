package com.anyu.system.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Anyu
 * @since 2020/7/18
 * mybatis-plus 自定义字段初始化
 */
@Component
public class MetaDataHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        //入职时间初始化
        this.strictInsertFill(metaObject,"entryTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject,"age", Integer.class,0);
        this.strictInsertFill(metaObject,"sex", Integer.class, 0);
        //员工数量
        this.strictInsertFill(metaObject,"employeeNum", Integer.class, 0);
        //状态
        this.strictInsertFill(metaObject,"status", Integer.class, 0);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
