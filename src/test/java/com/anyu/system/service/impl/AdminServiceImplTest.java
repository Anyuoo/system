package com.anyu.system.service.impl;

import com.anyu.system.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminServiceImplTest {

    @Autowired
    private AdminService adminService;
    @Test
    void login() {
        Map<String, Object> popo = adminService.login("popo", "123456");
        assertNull(popo);
    }

    @Test
    void register() {
        Map<String, Object> popo = adminService.register("popo", "123456");
        assertNull(popo);
    }

    @Test
    void getByName() {
    }
}