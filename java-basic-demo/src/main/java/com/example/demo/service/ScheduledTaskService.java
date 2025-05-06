package com.example.demo.service;

import com.example.demo.bean.ScheduledTask;

import java.util.Set;

/**
 * @Description:
 * @Author: Chenyang on 2025/05/06 15:24
 * @Version: 1.0
 */
public interface ScheduledTaskService {

    /**
     * 创建、修改定时任务
     *
     * @param task
     */
    void addOrUpdateTask(ScheduledTask task);

    /**
     * 删除定时任务
     *
     * @param taskId
     */
    Boolean cancelTask(String taskId);

    /**
     * 获取全部任务id
     */
    Set<String> getAllTaskIds();
}
