package com.example.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.cloud.entity.CommonResult;

/**
 * @Description: 自定义规则限流处理类
 * @Author: Chenyang on 2025/04/19 22:07
 * @Version: 1.0
 */
public class CustomBlockHandler {

    public static CommonResult<?> handleException1(BlockException be) {
        return new CommonResult<>(1234, "自定义限流处理方法1");
    }

    public static CommonResult<?> handleException2(BlockException be) {
        return new CommonResult<>(1234, "自定义限流处理方法2");
    }
}
