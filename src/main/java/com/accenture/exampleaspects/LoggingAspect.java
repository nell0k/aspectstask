package com.accenture.exampleaspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class LoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    public void beforeMethod() {
        System.out.println("Before: Calling greeting() method");
    }

    //@After("execution(void com.accenture.GreetingService.greeting())")
    public void afterMethod() {
        System.out.println("After: Calling greeting() method");
    }
    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        log.info( "{} executed in {}ms",joinPoint.getSignature().getName(), executionTime);
        return proceed;
    }
    @Around("execution(public * *GreetingService.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Before Around: Calling {}() method", joinPoint.getSignature().getName());
        Object retValue = joinPoint.proceed();
        log.info("After Around: Calling {}() method", joinPoint.getSignature().getName());
        return retValue;
    }
}
