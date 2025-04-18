package com.example.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/18 15:14
 * @Version: 1.0
 */
@RefreshScope
@RequestMapping("/config")
@RestController
public class ConfigClientController {
    
    @Value("${config.info:123}")
    private String configInfo;
    
    @Value("${server.port:}")
    private String serverPort;

    @GetMapping("/info")
    public String configInfo() {
        return "serverPort: " + serverPort + "\n configInfo: " + configInfo;
    }
}
