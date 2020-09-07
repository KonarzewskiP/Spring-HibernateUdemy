package spring_demo_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GymnasticCoach implements Coach {

    //Injecting from properties file, by using Java annotations
    @Value("${foo.email}")
    private String email;
    @Value("${foo.team}")
    private String team;

    private FortuneServices fortuneServices;

    public GymnasticCoach() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    //Method injection
    @Autowired
    @Qualifier("happyFortuneService")
    public void doSomeCrazyStuff(FortuneServices fortuneServices) {
        System.out.println(">> ChessCoach: inside doSomeCrazyStuff() method");
        this.fortuneServices = fortuneServices;
    }

    @Override
    public String getDailyWorkout() {
        return "Do 200 back flips.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneServices.getFortune();
    }
}
