package spring_demo_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach {

    //Field injection
    @Autowired
    @Qualifier("databaseFortuneService")
    private  FortuneServices fortuneServices;

    public SwimmingCoach() {
        System.out.println(">> SwimmingCoach: inside default constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 2 miles.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneServices.getFortune();
    }
}

