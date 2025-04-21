package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/21 8:38
 * @Version: 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosPaymentProvider9103 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentProvider9103.class, args);
    }
}
