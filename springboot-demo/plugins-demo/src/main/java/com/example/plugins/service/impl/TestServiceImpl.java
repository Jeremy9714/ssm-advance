package com.example.plugins.service.impl;

import com.example.plugins.service.ITestService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/01 10:39
 * @Version: 1.0
 */
@Service
public class TestServiceImpl implements ITestService {

    @Async("threadPoolTaskExecutor")
    @Override
    public void sayHello() {
        System.out.println(Thread.currentThread().getName() + ": Hello");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async("myThreadPoolExecutor")
    @Override
    public void sayHi() {
        System.out.println(Thread.currentThread().getName() + ": Hi");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
