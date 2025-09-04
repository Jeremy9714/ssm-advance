package com.example.dp.structural.dp05_facade;

/**
 * @Description: 外观类
 * @Author: Chenyang on 2025/04/23 18:10
 * @Version: 1.0
 */
public class SystemFacade {
    private SubSystemA systemA;
    private SubSystemB systemB;

    public SystemFacade() {
        this.systemA = new SubSystemA();
        this.systemB = new SubSystemB();
    }

    public void print() {
        systemA.print();
        systemB.print();
    }

    public static void main(String[] args) {
        SystemFacade systemFacade = new SystemFacade();
        systemFacade.print();
    }
}
