package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/19 9:37
 * @Version: 1.0
 */
@EnableDiscoveryClient // 服务注册
@SpringBootApplication
public class NacosPaymentProvider9102 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentProvider9102.class, args);
    }
}
