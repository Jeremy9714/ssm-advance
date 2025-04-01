package com.example.ssm;

import com.example.ssm.bean.MyBean;
import com.example.ssm.bean.User;
import com.example.ssm.config.MyConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description:
 * @Author: Chenyang on 2025/02/27 10:50
 * @Version: 1.0
 */
@SpringBootApplication
//@EnableAutoConfiguration
//@SpringBootConfiguration
//@ComponentScan(basePackages = "com.example.ssm")
public class Application {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

//        for (String name : context.getBeanDefinitionNames()) {
//            System.out.println(name);
//        }

//        System.out.println(context.containsBean("user01"));
//        for (String name : context.getBeanNamesForType(User.class)) {
//            System.out.println(name);
//        }
//        System.out.println("===================");
//        User user01 = context.getBean("user01", User.class);
//        User user02 = context.getBean("user02", User.class);
//        System.out.println(user01 == user02);

//        System.out.println(context.getBeanNamesForType(MyConfig.class).length);
    }


//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//            MyBean bean = ctx.getBean(MyBean.class);
//            bean.sayHello();
//        };
//    }
}
