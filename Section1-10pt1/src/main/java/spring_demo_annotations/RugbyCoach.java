package spring_demo_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RugbyCoach implements Coach{

    //Injecting from properties file, by using Java annotations
    @Value("${foo.email}")
    private String email;
    @Value("${foo.team}")
    private String team;

    private FortuneServices fortuneServices;

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

    @Autowired
    public RugbyCoach(FortuneServices fortuneServices) {
        this.fortuneServices = fortuneServices;
    }

    @Override
    public String getDailyWorkout() {
        return "Run 3 miles before breakfast";
    }

    @Override
    public String getDailyFortune() {
        return fortuneServices.getFortune();
    }
}
