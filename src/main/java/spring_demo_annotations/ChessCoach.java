package spring_demo_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ChessCoach implements Coach{

    private FortuneServices theFortuneService;

    public ChessCoach() {
        System.out.println(">> ChessCoach: inside default constructor");
    }

    public FortuneServices getTheFortuneService() {
        return theFortuneService;
    }

    //Setter injection
    @Autowired
    @Qualifier("databaseFortuneService")
    public void setTheFortuneService(FortuneServices theFortuneService) {
        System.out.println(">> ChessCoach: inside setTheFortuneService() method");
        this.theFortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practise openings for 3 hours";
    }

    @Override
    public String getDailyFortune() {
        return theFortuneService.getFortune();
    }
}
