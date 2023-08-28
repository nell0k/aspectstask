package com.accenture.exampleaspects;

import com.accenture.exampleaspects.GreetingService;

public class App {
    public static void main( String[] args ) {

        GreetingService greetingService = new GreetingService();
        greetingService.greeting();
        String value = greetingService.sayHello("Susi");
        System.out.println(value);
    }
}
