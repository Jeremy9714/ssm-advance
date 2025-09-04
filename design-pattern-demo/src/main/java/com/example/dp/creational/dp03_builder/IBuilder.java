package com.example.dp.creational.dp03_builder;

/**
 * @Description: 建造者接口
 * @Author: Chenyang on 2025/04/23 16:44
 * @Version: 1.0
 */
public interface IBuilder {

    void buildPart1(String part1);

    void buildPart2(String part2);

    Meal build();
}
