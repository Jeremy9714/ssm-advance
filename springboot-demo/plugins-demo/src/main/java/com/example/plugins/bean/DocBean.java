package com.example.plugins.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * @Description:
 * @Author: Chenyang on 2025/03/31 9:52
 * @Version: 1.0
 */
@Data
@Builder
@TableName("doc_tbl")
public class DocBean {
    @TableId
    private String id;
    private String name;
    private String gender;
    private int age;
    private String address;
    private String job;
}
