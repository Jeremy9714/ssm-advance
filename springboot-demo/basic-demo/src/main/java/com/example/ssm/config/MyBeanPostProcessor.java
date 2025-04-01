package com.example.ssm.config;

import com.example.ssm.bean.MyBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: Chenyang on 2025/03/31 15:08
 * @Version: 1.0
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyBean){
            System.out.println("------ beanPostProcessor.postProcessBeforeInitialization ------");
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyBean){
            System.out.println("------ beanPostProcessor.postProcessAfterInitialization ------");
        }
        return null;
    }
}
