package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/16 9:25
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient // 根据项目中引入的服务发现组件（如 Eureka、Consul、Nacos 等）自动配置相应的服务发现客户端。这个客户端会在应用启动时将应用的信息注册到服务注册中心，并定期从服务注册中心更新服务列表。
public class MainApplication8004 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication8004.class, args);
    }
}
