package net.proselyte.autowiring.ex7;

import org.springframework.context.ApplicationListener;

public class MyEventHandler implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        System.out.println(myEvent.toString());
    }
}
