package com.example.cloud.controller;

import com.example.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/17 9:21
 * @Version: 1.0
 */
@Slf4j
@RequestMapping("/payment")
@RestController
public class PayController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/success/{time}")
    public String success(@PathVariable("time") Integer time) {
        String result = paymentService.success(time);
        log.info("serverPort {} result is {}", serverPort, result);
        return result;
    }

    @GetMapping("/timeout/{time}")
    public String timeout(@PathVariable("time") Integer time) {
        String result = paymentService.timeout(time);
        log.info("serverPort {} result is {}", serverPort, result);
        return result;
    }

    @GetMapping("/circuit/{num}")
    public String circuitBreaker(@PathVariable("num") Integer num) {
        String result = paymentService.circuitBreaker(num);
        log.info("serverPort {} result is {}", serverPort, result);
        return result;
    }
}
