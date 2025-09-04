package com.example.dp.structural.dp03_composite;

/**
 * @Description: 叶子节点
 * @Author: Chenyang on 2025/04/23 17:52
 * @Version: 1.0
 */
public class LeafComponent implements Component {
    @Override
    public void print() {
        System.out.println("Leaf component");
    }
}
