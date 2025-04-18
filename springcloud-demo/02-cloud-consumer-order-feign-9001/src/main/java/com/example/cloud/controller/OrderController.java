package com.example.cloud.controller;

import com.example.cloud.entity.CommonResult;
import com.example.cloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/16 17:03
 * @Version: 1.0
 */
@Slf4j
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @RequestMapping("/consumer/get/{id}")
    public CommonResult<?> getPayment(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @RequestMapping("/consumer/timeout")
    public Integer timeout() {
        return paymentFeignService.timeout();
    }
}
