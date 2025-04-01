package com.example.ssm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description:
 * @Author: Chenyang on 2025/03/31 15:03
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyBean implements InitializingBean, BeanNameAware, BeanFactoryAware, DisposableBean {
    
    private String name;
    private String gender;
    private Integer age;
    
    public void sayHello(){
        System.out.println("------ Hello ------");
    }
    
    @PostConstruct
    public void postConstruct(){
        System.out.println("------ postConstruct ------");
    }
    
    @PreDestroy
    public void preDestroy(){
        System.out.println("------ preDestroy ------");
    }
    
    private void initMethod(){
        System.out.println("------ init-method ------");
    }
    
    private void destroyMethod(){
        System.out.println("------ destroy-method ------");
    }
    
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("------ beanFactoryAware.setBeanFactory ------");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("------ beanNameAware.setBeanName ------");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("------ disposable.destroy ------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("------ initializingBean.afterPropertiesSet ------");
    }
}
