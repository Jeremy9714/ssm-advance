package com.example.dp.creational.dp05_abstractfactory;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/23 17:19
 * @Version: 1.0
 */
public class ConcreteFactoryA implements IFactory{
    @Override
    public IShape createShape() {
        return new TriangleShape();
    }

    @Override
    public IColor createColor() {
        return new RedColor();
    }
}
