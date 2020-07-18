package com.anyu.system.config.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {

    //分页
    @Bean
    public PaginationInterceptor getPaginationInterceptor() {
        return new PaginationInterceptor();
    }
}
