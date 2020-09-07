package spring_demo_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// Default bean id is - tennisCoach
@Component/*("thatSillyCoach")*/
//@Scope("prototype")
public class TennisCoach implements Coach {

    //define a private field for the dependency
    private final FortuneServices fortuneServices;

    //Constructor injection
    //Spring will find a bean that implements FortuneService
    @Autowired
    TennisCoach(@Qualifier("randomFortuneService") FortuneServices theFortuneService) {
        System.out.println(">> TennisCoach: inside constructor");
        fortuneServices = theFortuneService;
    }

    //define init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println(">> TennisCoach: inside doMyStartupStuff() method");
    }

    //define destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println(">> TennisCoach: inside doMyCleanupStuff() method");
    }

    @Override
    public String getDailyFortune() {
        return fortuneServices.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "Practise your backhand volley.";
    }
}
