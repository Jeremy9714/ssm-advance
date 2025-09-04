package com.example.dp.structural.dp04_decorator;

/**
 * @Description: 具体装饰器
 * @Author: Chenyang on 2025/04/23 18:05
 * @Version: 1.0
 */
public class RedShapeDecorator extends AbstractDecorator {
    public RedShapeDecorator(IShape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void print() {
        super.print();
        addBehavior();
    }

    private void addBehavior() {
        System.out.println("Set border");
    }

    public static void main(String[] args) {
        TriangleShape triangleShape = new TriangleShape();
        RedShapeDecorator redShapeDecorator = new RedShapeDecorator(triangleShape);
        redShapeDecorator.print();
    }
}
