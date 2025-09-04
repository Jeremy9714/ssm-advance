package com.example.dp.behavior.dp01_chain;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/23 18:38
 * @Version: 1.0
 */
public class ConcreteHandlerA extends AbstractHandler{
    @Override
    void handleRequest(String request) {
        if (request.contains("A")){
            System.out.println("Handler A handling");
        }else{
            nextHandler.handleRequest(request);
        }
    }
}
