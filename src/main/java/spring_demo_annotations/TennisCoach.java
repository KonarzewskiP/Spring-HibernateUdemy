package spring_demo_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Default bean id is - tennisCoach
@Component/*("thatSillyCoach")*/
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

    @Override
    public String getDailyFortune() {
        return fortuneServices.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "Practise your backhand volley.";
    }
}
