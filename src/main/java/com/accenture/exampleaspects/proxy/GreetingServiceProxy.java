package com.accenture.exampleaspects.proxy;

import com.accenture.exampleaspects.LogExecutionTime;

public class GreetingServiceProxy implements GreetingService {
    private GreetingService greetingService;

    public GreetingServiceProxy(GreetingService greetingService){
        this.greetingService=greetingService;
    }
    @Override
    @LogExecutionTime
    public void greeting()  {

        System.out.println("before method");
        greetingService.greeting();
        System.out.println("after method");
    }
}
