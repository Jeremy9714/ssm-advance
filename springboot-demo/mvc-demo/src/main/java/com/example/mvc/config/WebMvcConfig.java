package com.example.mvc.config;

import com.example.mvc.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * @Description:
 * @Author: Chenyang on 2025/02/27 21:19
 * @Version: 1.0
 */
@Configuration
public class WebMvcConfig {

    /**
     * rest映射过滤器
     *
     * @return
     */
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        hiddenHttpMethodFilter.setMethodParam("_m");
        return hiddenHttpMethodFilter;
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                // 不移除分号(;) 后面的内容
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            // 自定义入参类型装换器
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, User>() {
                    @Override
                    public User convert(String source) {
                        if (source == null || "".equals(source)) {
                            return null;
                        }
                        String[] params = source.split(",");
                        User user = new User();
                        user.setName(params[0]);
                        user.setAge(Integer.parseInt(params[01]));
                        user.setGender(params[2]);
                        return user;
                    }
                });
            }
        };
    }
}
