package com.example.dp.creational.dp05_abstractfactory;

/**
 * @Description: 抽象工厂接口
 * @Author: Chenyang on 2025/04/23 17:16
 * @Version: 1.0
 */
public interface IFactory {

    IShape createShape();

    IColor createColor();
}
