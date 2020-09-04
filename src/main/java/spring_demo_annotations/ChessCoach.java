package spring_demo_annotations;

import org.springframework.stereotype.Component;

@Component
public class ChessCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practise openings for 3 hours";
    }

    @Override
    public String getDailyFortune() {
        return "You are future Grand Master!";
    }
}
