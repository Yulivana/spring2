package net.proselyte.autowiring;

import net.proselyte.autowiring.ex2.Person;
import net.proselyte.autowiring.ex4.annotations.Position;
import net.proselyte.autowiring.ex5.Message;
import net.proselyte.autowiring.ex5.MessageConfig;
import net.proselyte.autowiring.ex7.MyEventPublisher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {
    public static void main(String[] args) {
      //  autowiringByNameConfig();

     // autowiringByTypeConfig();

     //  autowiredConfig();

    //   annotationsQualifierConfig();

    //    messageRunner();

        messageRunnerJavaConfig();

     //   messageHandling();

     //   messageCustomHandling();

    }

    public static void autowiringByNameConfig(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("autowiring-by-name-config.xml");

        Exam exam = (Exam) context.getBean("exam");
        exam.examCheck();
    }

    public static void autowiringByTypeConfig(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("autowiring-by-type-config.xml");

        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }

    public static void autowiredConfig(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans-autowired-config.xml");

        net.proselyte.autowiring.ex3.Person person = (net.proselyte.autowiring.ex3.Person) context.getBean("person");
        System.out.println(person);
        context.close();
    }

    public static void annotationsQualifierConfig(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("annotations-qualifier-config.xml");

        Position position = (Position) context.getBean("position");

        position.getDevelopersInfo();
    }


    public static void messageRunner(){
        /*AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("annotations-jsr250-config.xml");*/
        ApplicationContext context = new AnnotationConfigApplicationContext(MessageConfig.class);
       // Message message = (Message) context.getBean("message");
        Message message = context.getBean(Message.class);
        message.setMessage("test 222");
        System.out.println(message.getMessage());

    }

    public static void messageRunnerJavaConfig(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(MessageConfig.class);
        Message message = context.getBean(Message.class);
        System.out.println(message);
    }

    public static void messageHandling(){
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("message-event-handling-config.xml");
        //context.start();
        net.proselyte.autowiring.ex6.Message message = (net.proselyte.autowiring.ex6.Message) context.getBean("message");
        System.out.println(message);
       // context.stop();
    }

    public static void messageCustomHandling(){
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("my-event-config.xml");

        MyEventPublisher myEventPublisher = (MyEventPublisher) context.getBean("myEventPublisher");
        myEventPublisher.publishEvent();
    }


}
