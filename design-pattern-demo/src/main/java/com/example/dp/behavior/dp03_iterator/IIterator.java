package com.example.dp.behavior.dp03_iterator;

/**
 * @Description: 迭代器接口
 * @Author: Chenyang on 2025/04/23 18:57
 * @Version: 1.0
 */
public interface IIterator<T> {
    boolean hasNext();
    T next();
}
