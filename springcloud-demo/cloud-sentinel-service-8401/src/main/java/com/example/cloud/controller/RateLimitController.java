package com.example.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.cloud.entity.CommonResult;
import com.example.cloud.entity.Payment;
import com.example.cloud.handler.CustomBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/19 21:36
 * @Version: 1.0
 */
@RequestMapping("/rate")
@RestController
public class RateLimitController {

    @GetMapping("/resource")
    @SentinelResource(value = "resource", blockHandler = "handleException")
    public CommonResult<?> resource() {
        return new CommonResult<>(200, "资源名称限流测试成功", new Payment(1L, "1-1-1"));
    }

    @GetMapping("/url")
    @SentinelResource(value = "url", blockHandler = "handleException")
    public CommonResult<?> url() {
        return new CommonResult<>(200, "url限流测试成功", new Payment(2L, "2-2-2"));
    }

    public CommonResult<?> handleException(BlockException be) {
        return new CommonResult<>(444, be.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping("/customBlockHandle")
    @SentinelResource(value = "customBlockHandle", blockHandlerClass = CustomBlockHandler.class,
            blockHandler = "handleException1")
    public CommonResult<?> customBockHandle() {
        return new CommonResult<>(200, "自定义处理");
    }
}
