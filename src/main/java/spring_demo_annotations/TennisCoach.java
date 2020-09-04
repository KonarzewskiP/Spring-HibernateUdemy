package spring_demo_annotations;

import org.springframework.stereotype.Component;

// Default bean id is - tennisCoach
@Component/*("thatSillyCoach")*/
public class TennisCoach implements Coach {

    //define a private field for the dependency
//    private FortuneServices fortuneServices;

//    BoxingCoach(FortuneServices theFortuneService) {
//        fortuneServices = theFortuneService;
//    }

    @Override
    public String getDailyFortune() {
        return "You are the best!";
    }

    @Override
    public String getDailyWorkout()
    {
        return "Practise your backhand volley.";
    }
}
