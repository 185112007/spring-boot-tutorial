package com.gafur.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Before("execution(* com.gafur.aop.service.MessageService.getMessage(..))")
    public void beforeGetMessage(JoinPoint joinPoint){
        System.out.println("before " + joinPoint.getSignature().getName() + "(param: " + joinPoint.getArgs()[0] + ")");
    }

    @After("execution(* com.gafur.aop.service.*.*(..))")
    public void afterGetMessage(JoinPoint joinPoint){
        System.out.println("after " + joinPoint.getSignature().getName() + "(param: " + joinPoint.getArgs()[0] + ")");
    }
}
