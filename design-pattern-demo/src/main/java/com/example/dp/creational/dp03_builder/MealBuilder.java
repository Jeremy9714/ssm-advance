package com.example.dp.creational.dp03_builder;

/**
 * @Description: 具体建造者
 * @Author: Chenyang on 2025/04/23 16:47
 * @Version: 1.0
 */
public class MealBuilder implements IBuilder {

    private String burger;
    private String drink;

    @Override
    public void buildPart1(String part1) {
        this.burger = part1;
    }

    @Override
    public void buildPart2(String part2) {
        this.drink = part2;
    }

    @Override
    public Meal build() {
        Meal meal = new Meal(burger, drink);
        return meal;
    }

    public static void main(String[] args) {
        MealBuilder builder = new MealBuilder();
        builder.buildPart1("cheese burger");
        builder.buildPart2("pepsi");
        Meal meal = builder.build();
        System.out.println(meal);
    }
    
}
