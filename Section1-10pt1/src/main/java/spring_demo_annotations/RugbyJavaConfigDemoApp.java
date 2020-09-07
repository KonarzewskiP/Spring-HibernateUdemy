package spring_demo_annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RugbyJavaConfigDemoApp {

    public static void main(String[] args) {

        //read spring config file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        //get the bean from the spring container
        RugbyCoach theCoach = context.getBean("rugbyCoach", RugbyCoach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        //call new methods with the props values injected
        System.out.println(theCoach.getEmail());
        System.out.println(theCoach.getTeam());
        System.out.println();

        //close the context
        context.close();

    }
}
