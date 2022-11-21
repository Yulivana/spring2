package net.proselyte.autowiring.ex5;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Message {
    private String message;

    private Person person;

    public String getMessage() {
        return "Message: " + message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @PostConstruct
    public void beanInit() {
        System.out.println("Bean is passing init stage.");
    }

    @PreDestroy
    public void beanDestroy() {
        System.out.println("Bean is passing destroy stage.");
    }

    public Person getPerson() {
        return person;
    }

    @Autowired(required = false)
    @Qualifier("Person2")
    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", person=" + person +
                '}';
    }
}
