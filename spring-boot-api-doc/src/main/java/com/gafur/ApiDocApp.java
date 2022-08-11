package com.gafur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class ApiDocApp {
    public static void main(String[] args) {
        SpringApplication.run(ApiDocApp.class, args);
    }
}
