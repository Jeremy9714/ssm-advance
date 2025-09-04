package com.example.dp.structural.dp06_flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 享元工厂类
 * @Author: Chenyang on 2025/04/23 18:19
 * @Version: 1.0
 */
public class FlyWeightFactory {
    private Map<String, FlyWeight> flyWeights = new HashMap<>();

    public FlyWeight getFlyWeight(String key) {
        FlyWeight flyWeight = flyWeights.get(key);
        if (flyWeight == null) {
            flyWeight = new ConcreteFlyWeight(key);
            flyWeights.put(key, flyWeight);
        }
        return flyWeight;
    }

    public static void main(String[] args) {
        FlyWeightFactory factory = new FlyWeightFactory();
        FlyWeight f1 = factory.getFlyWeight("f1");
        FlyWeight f2 = factory.getFlyWeight("f2");
        f1.print();
        f2.print();
    }
}
