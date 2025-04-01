package com.example.ssm.config;

import com.example.ssm.bean.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: Chenyang on 2025/03/31 15:10
 * @Version: 1.0
 */
@Configuration
public class MyBeanConfig {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public MyBean myBean() {
        return new MyBean();
    }
}
