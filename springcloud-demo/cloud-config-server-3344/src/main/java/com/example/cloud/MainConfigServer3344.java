package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/18 11:45
 * @Version: 1.0
 */
@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication
public class MainConfigServer3344 {
    public static void main(String[] args) {
        SpringApplication.run(MainConfigServer3344.class, args);
    }
}
