package com.app.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("classrom", r -> r.path("/api/classrom/**")
                        .filters(f -> f.rewritePath("/api/classrom/(?<segment>.*)", "/${segment}"))
                        .uri("lb://classrom"))
                .route("student", r -> r.path("/api/student/**")
                        .filters(f -> f.rewritePath("/api/student/(?<segment>.*)", "/${segment}"))
                        .uri("lb://student"))
                .build();
    }

}
