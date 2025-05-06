package com.example.demo.service.impl;

import com.example.demo.bean.ScheduledTask;
import com.example.demo.service.ScheduledTaskService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * @Description:
 * @Author: Chenyang on 2025/05/06 15:27
 * @Version: 1.0
 */
@Slf4j
@Service
public class ScheduledTaskServiceImpl implements ScheduledTaskService {

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    // 存储任务future
    private final Map<String, ScheduledFuture<?>> scheduledTasks = new ConcurrentHashMap();

    // 定时cron
    private final Map<String, String> cronTriggers = new ConcurrentHashMap<>();

    @Override
    public void addOrUpdateTask(ScheduledTask task) {
        log.info("------开始处理定时任务------");

        // 校验任务信息
        if (task == null || StringUtils.isBlank(task.getCronTab())) {
            throw new RuntimeException("Invalid task!");
        }
        try {
            validateCronTab(task.getCronTab());
        } catch (Exception e) {
            throw new RuntimeException("Invalid crontab", e);
        }

        String taskId = task.getId();
        String taskCron = task.getCronTab();

        // 存在任务且cron发生变化则取消旧任务
        if (scheduledTasks.containsKey(task.getId())) {
            if (!cronTriggers.get(taskId).equals(taskCron)) {
                cancelTask(task.getId());
                cronTriggers.put(taskId, taskCron);
            }
        }

        // 创建cronTask(runnable, cronTrigger)
        CronTask cronTask = new CronTask(() -> {
            System.out.println(taskId + " is running with expression: " + taskCron);
        }, taskCron);

        // 调度任务并保存future
        ScheduledFuture<?> future = taskScheduler.schedule(cronTask.getRunnable(), cronTask.getTrigger());
        cronTriggers.put(taskId, taskCron);
        scheduledTasks.put(taskId, future);
    }

    @Override
    public Boolean cancelTask(String taskId) {
        ScheduledFuture<?> scheduledFuture = scheduledTasks.get(taskId);
        if (scheduledFuture != null) {
            boolean isCanceled = scheduledFuture.cancel(true);
            if (isCanceled) {
                scheduledTasks.remove(taskId);
            }
            return isCanceled;
        }
        return false;
    }

    @Override
    public Set<String> getAllTaskIds() {
        return scheduledTasks.keySet();
    }

    // 校验crontab
    private static void validateCronTab(String cronTab) {
    }
}
