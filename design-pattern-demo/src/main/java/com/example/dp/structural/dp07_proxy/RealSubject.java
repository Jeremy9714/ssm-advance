package com.example.dp.structural.dp07_proxy;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/23 18:28
 * @Version: 1.0
 */
public class RealSubject implements Subject {
    @Override
    public void print() {
        System.out.println("Real subject");
    }
}
