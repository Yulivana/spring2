package net.proselyte.autowiring.ex5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    @Bean
    public Address getAddress1() {
        Address address = new Address();
        address.setCity("City1");
        address.setId(1L);
        return address;
    }

    @Bean TestAddress getAddress2() {
        TestAddress address = new TestAddress();
        return address;
    }

    @Bean(name = "Person1")
    Person getPerson1(){
        Person person = new Person();
        person.setId(1L);
        person.setName("name1");
        return person;
    }

    @Bean(name = "Person2")
        Person getPerson2(){
        Person person = new Person();
        person.setId(2L);
        person.setName("name2");
        person.setAddress(getAddress2());
        return person;
    }

    @Bean Message getMessage1(){
        Message message = new Message();
        message.setMessage("Message1");
        return message;
    }

}
