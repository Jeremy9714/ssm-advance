package com.example.dp.creational.dp03_builder;

/**
 * @Description: 产品类
 * @Author: Chenyang on 2025/04/23 16:45
 * @Version: 1.0
 */
public class Meal {

    private String burger;
    private String drink;

    @Override
    public String toString() {
        return "Meal{" +
                "burger='" + burger + '\'' +
                ", drink='" + drink + '\'' +
                '}';
    }

    public Meal(String burger, String drink) {
        this.burger = burger;
        this.drink = drink;
    }

    public void setBurger(String burger) {
        this.burger = burger;
    }

    public String getBurger() {
        return this.burger;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getDrink() {
        return this.drink;
    }
}
