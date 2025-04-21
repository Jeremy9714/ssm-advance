package com.example.cloud.controller;

import com.example.cloud.entity.CommonResult;
import com.example.cloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/21 8:39
 * @Version: 1.0
 */
@RequestMapping("/payment")
@RestController
public class PayController {

    @Value(("${server.port:}"))
    private String serverPort;

    public static final Map<Long, Payment> paymentMap = new HashMap<>();

    static {
        paymentMap.put(1L, new Payment(1L, "111"));
        paymentMap.put(2L, new Payment(2L, "222"));
        paymentMap.put(3L, new Payment(3L, "333"));
    }

    @GetMapping("/get/{id}")
    public CommonResult<?> getPayment(@PathVariable("id") Long id) {
        Payment payment = paymentMap.get(id);
        return new CommonResult<>(200, "Query payment from serverPort: " + serverPort, payment);
    }
}
