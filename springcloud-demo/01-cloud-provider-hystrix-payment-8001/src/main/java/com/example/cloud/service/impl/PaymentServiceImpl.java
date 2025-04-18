package com.example.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.example.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * @Description:
 * @Author: Chenyang on 2025/04/17 9:17
 * @Version: 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Value("${server.port}")
    private String serverPort;

    @Override
    public String success(Integer time) {
        return Thread.currentThread().getName() + " invoked method success!";
    }

    // 服务降级 (超时时间3s)
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                    value = "3000")
    })
    @Override
    public String timeout(Integer time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + " invoked method timeout!";
    }

    // 报错或超时会调用fallback方法
    public String fallback(Integer time) {
        return "Provider8001 " + Thread.currentThread().getName() + " invoked method fallback!";
    }

    // 服务熔断
    @HystrixCommand(fallbackMethod = "circuitFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 滚动时间窗口内，断路器判断的最小请求数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 断路器开启后的休眠时间长度，休眠结束后断路器变为半开状态，接收部分请求，请求成功则状态变为关闭，反之则开启
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 断路器开启所需的错误请求百分比
    })
    @Override
    public String circuitBreaker(Integer num) {
        if (num < 10) {
            throw new RuntimeException("数值小于10");
        }

        String id = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + " invoked method circuitBreaker\t  id=" + id;
    }

    public String circuitFallback(Integer num) {
        return "数据小于10, num:" + num;
    }
}
