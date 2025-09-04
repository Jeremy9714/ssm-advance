package com.example.dp.structural.dp01_adapter;

/**
 * @Description: 适配器类
 * @Author: Chenyang on 2025/04/23 17:30
 * @Version: 1.0
 */
public class Adaptor implements ITarget {

    private ISource source;

    public Adaptor(ISource source) {
        this.source = source;
    }

    @Override
    public void print() {
        System.out.println("------preHandle");
        source.printSource();
        System.out.println("------postHandle");
    }

    public static void main(String[] args) {
        SourceA sourceA = new SourceA();
        SourceB sourceB = new SourceB();
        Adaptor adaptorA = new Adaptor(sourceA);
        Adaptor adaptorB = new Adaptor(sourceB);
        adaptorA.print();
        adaptorB.print();
    }
}
