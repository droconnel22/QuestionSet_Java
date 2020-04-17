package com.springevents;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/*
Let’s create a simple event class – just a placeholder to
 store the event data. In this case, the event class
 holds a String message:
 */
public class CustomSpringEvent extends ApplicationEvent {

    private String message;

    public CustomSpringEvent(Object source, String message) {
        super(source);
        this.message =message;
    }

    public String getMessage(){
        return this.message;
    }
}

