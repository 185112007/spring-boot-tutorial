package com.gafur.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringAopApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringAopApp.class,args);
    }
}
