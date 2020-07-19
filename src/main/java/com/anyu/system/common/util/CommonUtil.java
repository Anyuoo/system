package com.anyu.system.common.util;

import org.springframework.util.DigestUtils;

import java.util.UUID;

public class CommonUtil {

    /**
     * 生成随机字符串
     */
    public static String generateUUIDString() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * md5加密
     * @param key key
     */
    public static String md5(String key) {
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

    public static String getCookieValue() {
        return "";
    }
}
