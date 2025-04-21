package com.example.cloud.controller;

import com.example.cloud.entity.CommonResult;
import com.example.cloud.entity.Order;
import com.example.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/21 12:21
 * @Version: 1.0
 */
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/create")
    public CommonResult<?> create(Order order) {
        orderService.create(order);
        return new CommonResult<>(20, "Successfully created an order");
    }
}
