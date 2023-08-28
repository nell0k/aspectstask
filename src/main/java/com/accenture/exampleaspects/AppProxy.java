package com.accenture.exampleaspects;

import com.accenture.exampleaspects.proxy.GreetingService;
import com.accenture.exampleaspects.proxy.GreetingServiceImpl;
import com.accenture.exampleaspects.proxy.GreetingServiceProxy;

public class AppProxy {
    public static void main(String[] args) {

        GreetingService greetingService = new GreetingServiceProxy(new GreetingServiceImpl());
        greetingService.greeting();
    }
}