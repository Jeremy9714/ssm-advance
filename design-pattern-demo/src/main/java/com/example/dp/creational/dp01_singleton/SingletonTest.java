package com.example.dp.creational.dp01_singleton;

/**
 * @Description: 单例模式
 * @Author: Chenyang on 2025/04/23 16:20
 * @Version: 1.0
 */
public class SingletonTest {
    private static volatile SingletonTest instance;

    private SingletonTest() {
    }

    public static SingletonTest getInstance() {
        if (instance == null) {
            synchronized (SingletonTest.class) {
                if (instance == null) {
                    instance = new SingletonTest();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonTest instance = SingletonTest.getInstance();
        SingletonTest instance2 = SingletonTest.getInstance();
        System.out.println(instance == instance2);
    }
}
