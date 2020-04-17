package com.springevents;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


// The only requirement for the listener is to be a bean
// and implement ApplicationListener interface:


@Component
public class CustomSpringEventListener implements ApplicationListener<CustomSpringEvent> {

    @Override
    public void onApplicationEvent(CustomSpringEvent customSpringEvent) {
        System.out.println("Recieved spring custom event - " + customSpringEvent.getMessage());
    }
}
