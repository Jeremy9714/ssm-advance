package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/19 10:00
 * @Version: 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosOrderConsumer9001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosOrderConsumer9001.class, args);
    }
}
