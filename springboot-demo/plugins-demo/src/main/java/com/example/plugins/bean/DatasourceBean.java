package com.example.plugins.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * @Description:
 * @Author: Chenyang on 2025/03/31 16:49
 * @Version: 1.0
 */
@Data
@Builder
@TableName("datasource_tbl")
public class DatasourceBean {
    
    @TableId(type= IdType.AUTO)
    private Integer id;
    
    private String name;
    
    @TableField("db_type")
    private String dbType;
    
    private String host;
    
    private String username;
    
    private String password;

}
