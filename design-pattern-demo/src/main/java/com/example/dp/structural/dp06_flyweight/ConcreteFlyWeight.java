package com.example.dp.structural.dp06_flyweight;

/**
 * @Description: 具体享元类
 * @Author: Chenyang on 2025/04/23 18:17
 * @Version: 1.0
 */
public class ConcreteFlyWeight implements FlyWeight {
    private String name;
    private Integer age;

    public ConcreteFlyWeight(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public void print() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
