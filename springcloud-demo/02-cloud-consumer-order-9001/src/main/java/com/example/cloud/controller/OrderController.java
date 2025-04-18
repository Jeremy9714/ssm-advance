package com.example.cloud.controller;

import com.example.cloud.entity.CommonResult;
import com.example.cloud.entity.Payment;
import com.example.cloud.lb.ILoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/15 10:48
 * @Version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    //    public final static String PAYMENT_URL = "http://localhost:8001/payment";
    public final static String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/payment";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ILoadBalancer loadBalancer;

    @GetMapping("/consumer/create")
    public CommonResult<Integer> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/getPaymentById/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/create2")
    public CommonResult<?> create2(Payment payment) {
        ResponseEntity<CommonResult> response = restTemplate.postForEntity(PAYMENT_URL + "/create", payment, CommonResult.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            return new CommonResult<>(500, "创建失败");
        }
    }

    @GetMapping("/consumer/get2/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> response = restTemplate.getForEntity(PAYMENT_URL + "/getPaymentById/" + id, CommonResult.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            return new CommonResult<>(500, "查询失败");
        }
    }

    @GetMapping("/consumer/lb")
    public Integer getLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        // 自定义负载均衡策略 获取服务实例
        ServiceInstance instance = loadBalancer.getInstance(instances);
        URI uri = instance.getUri();

        Integer response = restTemplate.getForObject(uri + "/payment/lb", Integer.class);
        return response;
    }
}
