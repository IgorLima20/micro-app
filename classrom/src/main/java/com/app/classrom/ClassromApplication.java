package com.app.classrom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.app.core.models")
@EnableJpaRepositories(basePackages = "com.app.core.repositories")
@EnableFeignClients
public class ClassromApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassromApplication.class, args);
    }

}
