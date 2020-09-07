package spring_demo_annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args) {

        //read spring config file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
        AnnotationConfigApplicationContext contextTwo = new AnnotationConfigApplicationContext(SportConfig.class);
        AnnotationConfigApplicationContext contextThree = new AnnotationConfigApplicationContext(SportConfig.class);
        AnnotationConfigApplicationContext contextFour = new AnnotationConfigApplicationContext(SportConfig.class);

        //get the bean from the spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach chessCoach = contextTwo.getBean("chessCoach", Coach.class);
        GymnasticCoach gymnasticCoach = contextThree.getBean("gymnasticCoach", GymnasticCoach.class);
        Coach swimmingCoach = contextFour.getBean("swimmingCoach", Coach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println();
        System.out.println(chessCoach.getDailyWorkout());
        System.out.println(chessCoach.getDailyFortune());
        System.out.println();
        System.out.println(gymnasticCoach.getDailyWorkout());
        System.out.println(gymnasticCoach.getDailyFortune());
        System.out.println(gymnasticCoach.getEmail());
        System.out.println(gymnasticCoach.getTeam());
        System.out.println();
        System.out.println(swimmingCoach.getDailyWorkout());
        System.out.println(swimmingCoach.getDailyFortune());
        System.out.println();
        //close the context
        context.close();
        contextTwo.close();
        contextThree.close();
        contextFour.close();
    }
}
