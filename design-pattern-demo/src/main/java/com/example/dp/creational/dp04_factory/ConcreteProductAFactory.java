package com.example.dp.creational.dp04_factory;

/**
 * @Description: 具体工厂
 * @Author: Chenyang on 2025/04/23 17:10
 * @Version: 1.0
 */
public class ConcreteProductAFactory extends BaseFactory {
    @Override
    public Product getProduct() {
        return new ConcreteProductA();
    }
}
