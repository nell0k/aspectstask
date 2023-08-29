package com.accenture.exampleaspects;

import com.accenture.exampleaspects.GreetingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        GreetingService greetingService = context.getBean(GreetingService.class);
        greetingService.greeting();
        String value = greetingService.sayHello("Susi");
        System.out.println(value);
    }
}
