package com.example.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/17 10:20
 * @Version: 1.0
 */
@Component
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE", fallback = OrderServiceFallback.class)
public interface OrderService {

    @GetMapping("/payment/success/{time}")
    String success(@PathVariable("time") Integer time);

    @GetMapping("/payment/timeout/{time}")
    String timeout(@PathVariable("time") Integer time);
}
