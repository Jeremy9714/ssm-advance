package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Author: Chenyang on 2025/05/06 9:44
 * @Version: 1.0
 */
@SpringBootTest
public class ThreadTest {

    @Test
    public void test1() throws InterruptedException {
        Thread thread = new Thread(() -> System.out.println(Thread.currentThread().getState()));
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        Thread.sleep(1000L);
        System.out.println(thread.getState());
    }

    @Test
    public void test2() throws InterruptedException {
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread is waiting");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread is resumed");
            }
        }).start();

        Thread.sleep(5000L);

        synchronized (lock) {
            lock.notify();
        }
    }

    @Test
    public void test3() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Thread is running");
            while (!Thread.currentThread().isInterrupted()) {
            }
            System.out.println("Thread is interrupted");
        });
        thread.start();

        Thread.sleep(3000L);
        thread.interrupt();
    }

    @Test
    public void test4() throws InterruptedException {
        Thread thread = new Thread(() -> System.out.println(Thread.currentThread().getName() + " is finished"));
        thread.setName("T1");
        thread.start();
        thread.join();
        System.out.println("Main Thread is finished");
    }
}
