package com.example.cloud.handler;

import com.example.cloud.entity.CommonResult;

/**
 * @Description: 自定义运行时异常处理类
 * @Author: Chenyang on 2025/04/21 9:15
 * @Version: 1.0
 */
public class CustomFallbackHandler {

    public static CommonResult<?> handleException1(Long id, Throwable t) {
        return new CommonResult<>(2345, "自定义运行时异常处理方法1");
    }

    public static CommonResult<?> handleException2(Throwable t) {
        return new CommonResult<>(2345, "自定义运行时异常处理方法1");
    }
}
