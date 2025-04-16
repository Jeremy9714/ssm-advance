package com.example.cloud.service;

import com.example.cloud.entity.Payment;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/14 16:59
 * @Version: 1.0
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
