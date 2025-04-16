package com.example.rbrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/16 11:21
 * @Version: 1.0
 */
@Configuration
public class MyRbRule { // 自定义Ribbon配置

    // Ribbon随机算法
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
