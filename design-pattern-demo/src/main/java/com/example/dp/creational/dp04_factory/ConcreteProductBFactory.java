package com.example.dp.creational.dp04_factory;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/23 17:10
 * @Version: 1.0
 */
public class ConcreteProductBFactory extends BaseFactory {
    @Override
    public Product getProduct() {
        return new ConcreteProductB();
    }
}
