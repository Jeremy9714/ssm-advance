package com.example.cloud.service;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/17 11:29
 * @Version: 1.0
 */
@Component
public class OrderServiceFallback implements OrderService {
    @Override
    public String success(Integer time) {
        return "Consumer9001 " + Thread.currentThread().getName() + " invoked success fallback!";
    }

    @Override
    public String timeout(Integer time) {
        return "Consumer9001 " + Thread.currentThread().getName() + " invoked timeout fallback!";
    }
}
