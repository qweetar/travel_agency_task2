package ru.myfirstwebsite.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* ru.myfirstwebsite.dao.*.*(..))")
    public void daoMethods() {}

    @Before("daoMethods()")
    public void daoRequest(JoinPoint jp) {
        LOGGER.info("Method " + jp.getSignature().getName() + " started");
    }

    @AfterReturning("execution(* ru.myfirstwebsite.dao.*.*.save(..))")
    public void daoSave(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        LOGGER.info("Method " + jp.getSignature().getName() + " successfully added " + args);
    }
}
