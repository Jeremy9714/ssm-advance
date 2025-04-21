package com.example.cloud.service;

import com.example.cloud.entity.CommonResult;
import com.example.cloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @Description: fallbackClass
 * @Author: Chenyang on 2025/04/21 9:36
 * @Version: 1.0
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<?> getPayment(Long id) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(4444, "Fallback method invoked!", payment);
    }
}
