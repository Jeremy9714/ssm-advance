package com.example.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/18 20:25
 * @Version: 1.0
 */
@EnableBinding(Sink.class)
@RequestMapping("/consumer")
@RestController
public class ReceiveMsgController {

    @Value("${server.port:}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void receive(Message<String> message) {
        System.out.println("ServerPort: " + serverPort + " received the message '" + message.getPayload() + "'");
    }
}
