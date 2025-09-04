package com.example.dp.creational.dp02_prototype;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/23 16:33
 * @Version: 1.0
 */
public class ConcretePrototype implements IPrototype {
    private String data;

    public ConcretePrototype(String data) {
        this.data = data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    // 使用深拷贝
    @Override
    protected IPrototype clone() {
        IPrototype clone = null;
        try {
            clone = (IPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    public static void main(String[] args) {
        ConcretePrototype prototypeObj1 = new ConcretePrototype("Prototype data");
        ConcretePrototype prototypeObj2 = (ConcretePrototype) prototypeObj1.clone();
        
        prototypeObj2.setData("New Prototype data");
        System.out.println(prototypeObj1.getData().equals(prototypeObj2.getData()));

        System.out.println(prototypeObj1);
        System.out.println(prototypeObj2);
    }
}
