package com.example.plugins.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @Description:
 * @Author: Chenyang on 2025/04/01 10:32
 * @Version: 1.0
 */
@Configuration
@EnableAsync // 允许使用异步方法
public class ThreadPoolConfig {

    @Bean
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        threadPoolTaskExecutor.setCorePoolSize(5);
        // 设置最大线程数
        threadPoolTaskExecutor.setMaxPoolSize(5);
        // 设置工作队列大小
        threadPoolTaskExecutor.setQueueCapacity(1);
        // 设置线程名称前缀
        threadPoolTaskExecutor.setThreadNamePrefix("ThreadPoolTaskExecutor--");
        // 设置拒绝策略 (工作队列满、线程数为最大线程数时，接受新任务抛出异常)
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        // 初始化线程池
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    @Bean
    public Executor myThreadPoolExecutor() {
        // 设置核心线程数
        int corePoolSize = 5;
        // 设置最大线程数
        int maxPoolSize = 5;
        // 设置工作队列大小
        int queueCapacity = 1;
        // 设置最大存活时间
        int keepAliveTime = 10;
        // 设置线程名前缀
        String threadNamePrefix = "ThreadPoolExecutor--";
        // 设置自定义拒绝策略
        RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                throw new RejectedExecutionException("自定义的exception");
            }
        };
        // 自定义线程工厂
        ThreadFactory threadFactory = new ThreadFactory() {
            private AtomicInteger i = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName(threadNamePrefix + i.getAndIncrement());
                return thread;
            }
        };

        // 初始化线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(queueCapacity),
                threadFactory, rejectedExecutionHandler);
        return threadPoolExecutor;
    }
}
