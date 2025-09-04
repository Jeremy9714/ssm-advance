package com.example.dp.creational.dp04_factory;

/**
 * @Description: 具体产品
 * @Author: Chenyang on 2025/04/23 16:57
 * @Version: 1.0
 */
public class ConcreteProductA implements Product {
    @Override
    public void print() {
        System.out.println("ConcreteProductA info");
    }
}
