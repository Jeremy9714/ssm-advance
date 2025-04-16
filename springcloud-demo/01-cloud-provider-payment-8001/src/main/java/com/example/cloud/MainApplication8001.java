package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/14 16:35
 * @Version: 1.0
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class MainApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication8001.class,args);
    }
}
