package com.example.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/19 9:39
 * @Version: 1.0
 */
@RequestMapping("/payment")
@RestController
public class PayController {

    @Value("${server.port:}")
    private String serverPort;

    @GetMapping("/nacos/{id}")
    public String getPayment(@PathVariable("id") String id) {
        return "Id: " + id + " at serverPort: " + serverPort;
    }
}
