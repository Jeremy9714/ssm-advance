package cmo.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/16 9:54
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MainApplication9004 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication9004.class, args);
    }
}
