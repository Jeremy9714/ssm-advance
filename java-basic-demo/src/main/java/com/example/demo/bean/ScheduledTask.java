package com.example.demo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description:
 * @Author: Chenyang on 2025/05/06 15:21
 * @Version: 1.0
 */
@Data
@TableName("cron_tbl")
public class ScheduledTask {

    @TableId
    private String id;

    @TableField("cron_tab")
    private String cronTab;

    private String status;
}
