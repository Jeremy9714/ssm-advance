package com.example.cloud.service;

import com.example.cloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/16 17:05
 * @Version: 1.0
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @RequestMapping("/payment/getPaymentById/{id}")
    CommonResult<?> getPaymentById(@PathVariable("id") Long id);
    
    @RequestMapping("/payment/timeout")
    Integer timeout();
}
