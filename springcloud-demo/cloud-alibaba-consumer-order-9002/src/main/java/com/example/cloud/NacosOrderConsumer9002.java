package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/19 10:00
 * @Version: 1.0
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class NacosOrderConsumer9002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosOrderConsumer9002.class, args);
    }
}
