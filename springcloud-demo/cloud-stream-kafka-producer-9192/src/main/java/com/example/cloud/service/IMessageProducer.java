package com.example.cloud.service;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/18 17:49
 * @Version: 1.0
 */
public interface IMessageProducer {

    /**
     * 发送消息
     * @return
     * @param num
     */
    void send(String num);
}
