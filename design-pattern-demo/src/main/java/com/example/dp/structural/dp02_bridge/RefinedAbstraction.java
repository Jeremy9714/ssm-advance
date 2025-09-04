package com.example.dp.structural.dp02_bridge;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/23 17:41
 * @Version: 1.0
 */
public class RefinedAbstraction extends Abstraction {

    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    void print() {
        System.out.println("Refined abstraction");
        implementor.printMsg();
    }

    public static void main(String[] args) {
        ImplementorA implementorA = new ImplementorA();
        RefinedAbstraction refinedAbstraction = new RefinedAbstraction(implementorA);
        refinedAbstraction.print();
    }
}
