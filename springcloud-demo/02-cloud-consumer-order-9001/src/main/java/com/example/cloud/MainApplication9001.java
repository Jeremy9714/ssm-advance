package com.example.cloud;

import com.example.rbrule.MyRbRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/15 10:47
 * @Version: 1.0
 */
@EnableDiscoveryClient
@EnableEurekaClient
// 指定服务名和RB策略
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyRbRule.class)
@SpringBootApplication
public class MainApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication9001.class, args);
    }
}
