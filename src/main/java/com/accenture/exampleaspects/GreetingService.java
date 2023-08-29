package com.accenture.exampleaspects;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class GreetingService {

    private static final Logger log = LoggerFactory.getLogger(GreetingService.class);
    @LogExecutionTime
    public void greeting(){
        log.info("Before Around: Calling greeting() method");
        System.out.println("Hello Aspect");
        log.info("After Around: Calling greeting() method");
    }
    @LogExecutionTime
    public String sayHello(String name ) {
        log.info("Before Around: Calling sayHello() method");
        log.info("After Around: Calling saHello() method");
        return"Hallo " + name;
    }
}
