package com.example.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.cloud.entity.CommonResult;
import com.example.cloud.entity.Payment;
import com.example.cloud.handler.CustomFallbackHandler;
import com.example.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/19 10:01
 * @Version: 1.0
 */
@Slf4j
@RequestMapping("/cb")
@RestController
public class CircuitBreakerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PaymentService paymentService; // feign

    @Value("${service-url.nacos-provider-service:}")
    private String serviceUrl;

    //    @SentinelResource(value = "fallback")
//    @SentinelResource(value = "fallback", fallback = "fallbackHandler") // fallback处理运行时异常
//    @SentinelResource(value = "fallback", fallbackClass = CustomFallbackHandler.class, fallback = "handleException1")
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler") // blockHandler处理配置规则异常
//    @SentinelResource(value = "fallback", fallback = "fallbackHandler", blockHandler = "blockHandler") 
    @SentinelResource(value = "fallback", fallback = "fallbackHandler", exceptionsToIgnore = {IllegalArgumentException.class})
    // exceptionsToIgnore忽略异常组
    @GetMapping("/consumer/fallback/{id}")
    public CommonResult<?> getPayment(@PathVariable("id") Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(serviceUrl + "/payment/get/" + id, CommonResult.class);
        if (id == 4) {
            throw new IllegalArgumentException("非法参数！");
        } else if (result.getData() == null) {
            throw new NullPointerException("找不到数据！");
        }
        return result;
    }

    // 运行时异常兜底方法
    public CommonResult<?> fallbackHandler(Long id, Throwable t) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(444, "Fallback method invoked! Exception message: " + t.getMessage(), payment);
    }

    // 配置规则异常兜底方法
    public CommonResult<?> blockHandler(Long id, BlockException be) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(445, "BlockHandler method invoked! Exception message: " + be.getMessage(), payment);
    }

    @GetMapping("/consumer/feign/{id}")
    public CommonResult<?> getFeignPayment(@PathVariable("id") Long id) {
        return paymentService.getPayment(id);
    }
}
