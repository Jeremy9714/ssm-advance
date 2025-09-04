package com.example.dp.behavior.dp03_iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/23 18:58
 * @Version: 1.0
 */
public class ConcreteContainer implements Container<String> {

    private List<String> names = new ArrayList<>();

    public void add(String name) {
        names.add(name);
    }

    @Override
    public IIterator<String> iterator() {
        return new ConcreteIterator();
    }

    private class ConcreteIterator implements IIterator<String> {

        int index;

        @Override
        public boolean hasNext() {
            return index < names.size();
        }

        @Override
        public String next() {
            return names.get(index++);
        }
    }

    public static void main(String[] args) {
        ConcreteContainer concreteContainer = new ConcreteContainer();
        concreteContainer.add("A");
        concreteContainer.add("B");
        concreteContainer.add("C");
        IIterator<String> iterator = concreteContainer.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
