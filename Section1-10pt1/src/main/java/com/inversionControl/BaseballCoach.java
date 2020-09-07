package com.inversionControl;

public class BaseballCoach implements Coach {

    private FortuneServices fortuneServices;

    public BaseballCoach(FortuneServices fortuneServices) {
        this.fortuneServices = fortuneServices;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
