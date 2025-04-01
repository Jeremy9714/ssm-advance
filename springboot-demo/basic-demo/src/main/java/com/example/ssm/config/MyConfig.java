package com.example.ssm.config;

import com.example.ssm.bean.Car;
import com.example.ssm.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Description:
 * @Author: Chenyang on 2025/02/27 15:48
 * @Version: 1.0
 */
@ImportResource("classpath:beans.xml")
@Configuration(proxyBeanMethods = false)
@ConditionalOnMissingBean(name = "user")
//@ConditionalOnProperty(prefix = "global.config", name = "enable", havingValue = "true", matchIfMissing = true)
// 开启指定类配置绑定功能 并将其组件注入容器
@EnableConfigurationProperties(Car.class)
public class MyConfig {

    @Bean
    public User user02() {
        return new User("Sean", 30, "male");
    }

}
