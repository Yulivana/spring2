package net.proselyte.autowiring.ex6;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class MyStartEventHander implements ApplicationListener<ContextStartedEvent> {
    public void onApplicationEvent(ContextStartedEvent event){
        System.out.println("We've received ContextStartedEvent...");
    }
}
