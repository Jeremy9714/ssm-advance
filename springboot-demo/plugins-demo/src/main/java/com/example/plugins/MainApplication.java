package com.example.plugins;

import com.example.plugins.service.DocService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:
 * @Author: Chenyang on 2025/03/31 9:09
 * @Version: 1.0
 */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
//        for (String beanDefinitionName : run.getBeanDefinitionNames()) {
//            System.out.println(beanDefinitionName);
//        }

//        String[] beanNamesForType = run.getBeanNamesForType(DocService.class);
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }
    }
}
