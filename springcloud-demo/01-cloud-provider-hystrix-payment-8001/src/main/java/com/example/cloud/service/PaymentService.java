package com.example.cloud.service;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/17 9:16
 * @Version: 1.0
 */
public interface PaymentService {
    
    String success(Integer time);
    
    String timeout(Integer time);
    
    String circuitBreaker(Integer num);
}
