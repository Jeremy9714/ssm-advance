package com.example.plugins.util;

import java.util.UUID;

/**
 * @Description:
 * @Author: Chenyang on 2025/03/31 17:12
 * @Version: 1.0
 */
public class GlobalUtils {

    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }
}
