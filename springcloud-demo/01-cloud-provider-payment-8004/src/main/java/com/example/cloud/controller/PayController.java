package com.example.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/16 9:26
 * @Version: 1.0
 */
@Slf4j
@RequestMapping("/payment")
@RestController
public class PayController {

    @Autowired
    private ServerProperties serverProperties;

    @GetMapping("/zk")
    public String zkInfo() {
        return "SpringCloud zookeeper registry: " + serverProperties.getPort();
    }
}
