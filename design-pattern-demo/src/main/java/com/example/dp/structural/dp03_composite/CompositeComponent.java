package com.example.dp.structural.dp03_composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 容器节点
 * @Author: Chenyang on 2025/04/23 17:53
 * @Version: 1.0
 */
public class CompositeComponent implements Component {

    private List<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void print() {
        System.out.println("Composite component");
        for (Component child : children) {
            child.print();
        }
    }

    public static void main(String[] args) {
        LeafComponent lc1 = new LeafComponent();
        LeafComponent lc2 = new LeafComponent();
        CompositeComponent composite = new CompositeComponent();
        composite.add(lc1);
        composite.add(lc2);
        composite.print();
    }
}
