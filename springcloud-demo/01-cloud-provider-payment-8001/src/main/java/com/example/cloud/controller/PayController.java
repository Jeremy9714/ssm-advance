package com.example.cloud.controller;

import com.example.cloud.entity.CommonResult;
import com.example.cloud.entity.Payment;
import com.example.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/14 17:27
 * @Version: 1.0
 */
@Slf4j
@RequestMapping("/payment")
@RestController
public class PayController {
//    private static final Logger log = LoggerFactory.getLogger(PayController.class);

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ServerProperties serverProperties;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult<?> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("------插入结果: {}", result);

        if (result > 0) {
            return new CommonResult<>(200, "插入成功，服务器为: " + serverProperties.getPort(), result);
        } else {
            return new CommonResult<>(500, "插入失败");
        }
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult<?> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("------查询结果: {}", payment);

        if (payment != null) {
            return new CommonResult<>(200, "查询成功，服务器为: " + serverProperties.getPort(), payment);
        } else {
            return new CommonResult<>(500, "查询失败，id为：" + id);
        }
    }

    @GetMapping("/discovery")
    public Object discovery() {
        // 获取服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("------service: {}", service);
        }

        // 获取指定服务的实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("------instance: {}\t host:{}\t port:{}\t uri:{}", instance.getServiceId(), instance.getHost(), instance.getPort(), instance.getUri());
        }

        return this.discoveryClient;
    }
    
    @GetMapping("/lb")
    public Integer getLB(){
        return serverProperties.getPort();
    }
    
    @GetMapping("/timeout")
    public Integer timeout(){
        try{
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverProperties.getPort();
    }
}
