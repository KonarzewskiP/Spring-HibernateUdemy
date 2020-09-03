package com.inversionControl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassPathXmlApplicationContext contextTwo =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);
        Coach boxingCoach = contextTwo.getBean("boxingCoach", Coach.class);

        // call methods on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(boxingCoach.getDailyWorkout());

        // call methods for fortunes
        System.out.println(theCoach.getDailyFortune());
        System.out.println(boxingCoach.getDailyFortune());

        // close the context
        context.close();
        contextTwo.close();
    }

}
