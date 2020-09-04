package spring_demo_annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {

        //read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springDemoContext.xml");
        ClassPathXmlApplicationContext contextTwo = new ClassPathXmlApplicationContext("springDemoContext.xml");

        //get the bean from the spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach chessCoach = contextTwo.getBean("chessCoach", Coach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println(chessCoach.getDailyWorkout());
        System.out.println(chessCoach.getDailyFortune());

        //close the context
        context.close();
        contextTwo.close();
    }
}
