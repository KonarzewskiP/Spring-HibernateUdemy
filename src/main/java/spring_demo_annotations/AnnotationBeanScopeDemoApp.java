package spring_demo_annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {


        //load spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("springDemoComponentScan.xml");

        //retrieve bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        Coach chessCoach = context.getBean("tennisCoach", Coach.class);

        //check if they are the same
        boolean result = (theCoach == chessCoach);

        //print out the result
        System.out.println("\nPointing to the same object: "+result);

        System.out.println("\nMemory location fot theCoach " + theCoach);

        System.out.println("\nMemory location fot chessCoach " + chessCoach + "\n");

        //close the context
        context.close();

    }
}
