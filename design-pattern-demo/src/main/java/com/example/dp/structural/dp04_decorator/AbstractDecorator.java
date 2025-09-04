package com.example.dp.structural.dp04_decorator;


/**
 * @Description: 装饰器抽象类
 * @Author: Chenyang on 2025/04/23 18:02
 * @Version: 1.0
 */
public abstract class AbstractDecorator implements IShape {
    protected IShape decoratedShape;

    public AbstractDecorator(IShape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void print() {
        decoratedShape.print();
    }
}
