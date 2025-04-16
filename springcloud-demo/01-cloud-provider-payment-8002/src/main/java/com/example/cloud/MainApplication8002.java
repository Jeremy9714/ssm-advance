package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/14 16:35
 * @Version: 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class MainApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication8002.class,args);
    }
}
