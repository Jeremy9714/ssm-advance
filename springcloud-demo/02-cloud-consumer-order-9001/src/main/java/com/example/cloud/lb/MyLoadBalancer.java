package com.example.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/16 11:50
 * @Version: 1.0
 */
@Component
public class MyLoadBalancer implements ILoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(1);

    @Override
    public ServiceInstance getInstance(List<ServiceInstance> instances) {
        int index = getAndIncrement() % instances.size();
        return instances.get(index);
    }

    private final int getAndIncrement() {
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("------访问次数：" + next);
        return next;
    }
}
