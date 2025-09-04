package com.example.dp.behavior.dp01_chain;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/23 18:39
 * @Version: 1.0
 */
public class ConcreteHandlerB extends AbstractHandler {
    @Override
    void handleRequest(String request) {
        if (request.contains("B")) {
            System.out.println("Handler B handling");
        } else {
            nextHandler.handleRequest(request);
        }
    }

    public static void main(String[] args) {
        ConcreteHandlerA handlerA = new ConcreteHandlerA();
        ConcreteHandlerB handlerB = new ConcreteHandlerB();
        handlerA.setNextHandler(handlerB);

        handlerA.handleRequest("A");
        handlerA.handleRequest("B");
        handlerA.handleRequest("C");
    }
}
