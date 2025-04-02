package com.example.photoserviceapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {
    //private final Logger LOGGER = LoggerFactory.getLogger("BeforeLogger");

    @Before("execution(* com.example.photoserviceapp.*.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("Logger before is working: " + joinPoint.getSignature().getName());
    }
}
