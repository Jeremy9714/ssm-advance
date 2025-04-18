package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/16 17:02
 * @Version: 1.0
 */
@EnableFeignClients
@SpringBootApplication
public class FeignApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(FeignApplication9001.class, args);
    }
}
