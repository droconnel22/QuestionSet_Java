package com.springevents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CustomSpringEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void doStuffAndPublishEvent(final String message) {
        var event = new CustomSpringEvent(this,message);
        applicationEventPublisher.publishEvent(event);
    }
}

