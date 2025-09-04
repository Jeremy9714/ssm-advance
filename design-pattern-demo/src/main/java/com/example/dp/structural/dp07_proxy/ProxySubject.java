package com.example.dp.structural.dp07_proxy;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/23 18:28
 * @Version: 1.0
 */
public class ProxySubject implements Subject {
    private RealSubject realSubject;

    @Override
    public void print() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        // 代理控制对真实主题的访问
        realSubject.print();
    }
}
