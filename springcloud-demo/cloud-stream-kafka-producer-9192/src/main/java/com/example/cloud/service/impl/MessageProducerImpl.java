package com.example.cloud.service.impl;

import com.example.cloud.service.IMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/18 17:50
 * @Version: 1.0
 */
@EnableBinding(Source.class) // 绑定channel和broker
public class MessageProducerImpl implements IMessageProducer {

    @Autowired
    private MessageChannel output; // outputs

    @Override
    public void send(String num) {
        output.send(MessageBuilder
                .withPayload(num) // 内容
                .build());
    }
}
