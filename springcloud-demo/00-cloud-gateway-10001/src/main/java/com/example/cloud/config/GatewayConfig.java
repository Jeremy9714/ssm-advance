package com.example.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/17 20:53
 * @Version: 1.0
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator myRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("to_baidu_test", r -> r.path("/test")
                        .uri("http://tieba.baidu.com/test"))
                .route("to_baidu_baidu", r -> r.path("/baidu")
                        .uri("http://tieba.baidu.com/baidu"))
                .build();
        return routes.build();
    }
}
