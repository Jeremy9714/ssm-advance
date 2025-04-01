package com.example.basic;

import org.junit.Test;

/**
 * @Description:
 * @Author: Chenyang on 2025/03/27 20:29
 * @Version: 1.0
 */
public class BasicTest {

    @Test
    public void test1() throws InterruptedException {
        Object obj = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread.sleep(500L);
        System.out.println(t1.getState());
    }
}
