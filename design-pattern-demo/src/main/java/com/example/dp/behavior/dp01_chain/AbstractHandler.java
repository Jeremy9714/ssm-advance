package com.example.dp.behavior.dp01_chain;

/**
 * @Description: 抽象处理者类
 * @Author: Chenyang on 2025/04/23 18:32
 * @Version: 1.0
 */
public abstract class AbstractHandler {

    protected AbstractHandler nextHandler;

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    
    abstract void handleRequest(String request);
}
