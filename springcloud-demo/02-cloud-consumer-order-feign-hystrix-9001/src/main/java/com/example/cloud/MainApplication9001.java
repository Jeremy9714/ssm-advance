package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/17 10:19
 * @Version: 1.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix // 包括了@EnableCircuitBreaker
public class MainApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication9001.class, args);
    }
}
