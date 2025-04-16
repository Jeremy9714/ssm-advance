package cmo.example.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/16 9:56
 * @Version: 1.0
 */
@Slf4j
@RequestMapping("/order")
@RestController
public class OrderController {

    private static final String SERVICE_URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/zk")
    public String zkInfo() {
        String result = restTemplate.getForObject(SERVICE_URL + "/payment/zk", String.class);
        return result;
    }
}
