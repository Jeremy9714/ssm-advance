package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/18 12:27
 * @Version: 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class MainConfigClient3355 {
    public static void main(String[] args) {
        SpringApplication.run(MainConfigClient3355.class, args);
    }
}
