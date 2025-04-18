package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/17 20:34
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class MainGateway10001 {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MainGateway10001.class, args);
//        for (String name : context.getBeanNamesForType(RouteLocator.class)) {
//            System.out.println(name);
//        }
    }
}
