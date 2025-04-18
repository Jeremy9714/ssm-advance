package com.example.cloud.controller;

import com.example.cloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/17 10:28
 * @Version: 1.0
 */
@Slf4j
@DefaultProperties(defaultFallback = "globalFallback", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                value = "1500")
}) // hystrix公共降级处理
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/consumer/success/{time}")
    public String success(@PathVariable("time") Integer time) {
        return orderService.success(time);
    }

    //    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
//                    value = "1500")
//    })
    @HystrixCommand
    @GetMapping("/consumer/timeout/{time}")
    public String timeout(@PathVariable("time") Integer time) {
        return orderService.timeout(time);
    }

    public String fallback(Integer time) {
        return "Consumer9001 " + Thread.currentThread().getName() + " invoked method fallback!";
    }

    // 公共fallback
    public String globalFallback() {
        return "Consumer9001 " + Thread.currentThread().getName() + " invoked global fallback!";
    }
}
