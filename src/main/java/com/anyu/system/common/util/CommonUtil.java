package com.anyu.system.common.util;

import java.util.UUID;

public class CommonUtil {

    public static String generateUUIDString(String key) {
        return UUID.fromString(key).toString().replace(" ", "-").strip();
    }
    public static String generateUUIDString() {
        return UUID.randomUUID().toString().replace(" ", "-").strip();
    }

    public static String getCookieValue() {
        return "";
    }
}
