package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/17 15:09
 * @Version: 1.0
 */
@EnableHystrixDashboard
@SpringBootApplication
public class MainHystrixDashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(MainHystrixDashboard9001.class, args);
    }
}
