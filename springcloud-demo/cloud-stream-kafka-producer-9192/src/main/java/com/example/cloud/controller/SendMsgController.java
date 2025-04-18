package com.example.cloud.controller;

import com.example.cloud.service.IMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/18 17:56
 * @Version: 1.0
 */
@RequestMapping("/producer")
@RestController
public class SendMsgController {

    @Autowired
    private IMessageProducer messageProducer;

    @GetMapping("/send/{num}")
    public String send(@PathVariable("num") String num) {
        System.out.println("------num: " + num);
        messageProducer.send(num);
        return "Method send invoked!";
    }
}
