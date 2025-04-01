package com.example.ssm.controller;

import com.example.ssm.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Chenyang on 2025/02/27 16:11
 * @Version: 1.0
 */
@RestController
public class MainController {

    @Autowired
    private Car car;

    @RequestMapping("/car")
    public Car getCar() {
        return car;
    }
}
