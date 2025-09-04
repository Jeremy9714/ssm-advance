package com.example.dp.structural.dp02_bridge;

/**
 * @Description: 抽象化类
 * @Author: Chenyang on 2025/04/23 17:40
 * @Version: 1.0
 */
public abstract class Abstraction {
    // 实现化对象
    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }
    
    // 实现接口
    abstract void print();
}
