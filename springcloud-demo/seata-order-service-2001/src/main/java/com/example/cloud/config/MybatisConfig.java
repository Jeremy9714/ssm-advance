package com.example.cloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/21 12:32
 * @Version: 1.0
 */
@Configuration
@MapperScan({"com.example.cloud.dao"})
public class MybatisConfig {
}
