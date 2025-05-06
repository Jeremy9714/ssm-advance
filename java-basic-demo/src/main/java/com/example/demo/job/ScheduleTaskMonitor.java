package com.example.demo.job;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * @Description: 配置定时任务的线程池
 * @Author: Chenyang on 2025/05/06 14:56
 * @Version: 1.0
 */
//@Component
@Configuration
public class ScheduleTaskMonitor implements SchedulingConfigurer {

    @Value("${scheduler.pool-size:50}")
    private Integer poolSize;

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setThreadNamePrefix("scheduled-task-");
        threadPoolTaskScheduler.setPoolSize(poolSize);
        threadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown(true);
        threadPoolTaskScheduler.setAwaitTerminationSeconds(60);
        threadPoolTaskScheduler.initialize();
        return threadPoolTaskScheduler;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = threadPoolTaskScheduler();
        // 设置线程池
        taskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
    }

//    @Scheduled(fixedRate = 1000L)
//    public void runTaskWithFixedRate() {
//        System.out.println("FixedRate 1000L");
//    }
//
//    @Scheduled(fixedDelay = 1000L)
//    public void runTaskWithFixedDelay() throws InterruptedException {
//        System.out.println("FixedDelay 1000L");
//        Thread.sleep(5000L);
//    }
//
//    @Scheduled(cron = "0 * * * * ?")
//    public void runTaskEveryMinute() {
//        System.out.println("Every minute cron");
//    }
}
