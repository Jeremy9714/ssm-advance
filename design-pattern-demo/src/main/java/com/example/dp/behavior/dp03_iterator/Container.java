package com.example.dp.behavior.dp03_iterator;

/**
 * @Description: 聚合接口
 * @Author: Chenyang on 2025/04/23 18:57
 * @Version: 1.0
 */
public interface Container<T> {
    IIterator<T> iterator();
}
