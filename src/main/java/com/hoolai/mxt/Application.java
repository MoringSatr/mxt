package com.hoolai.mxt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.hoolai.mxt.repository")
@EntityScan(basePackages = "com.hoolai.mxt.entity")
public class Application {

    public static void main(String[] args) {
        new SpringApplication(Application.class).run(args);
    }
}
