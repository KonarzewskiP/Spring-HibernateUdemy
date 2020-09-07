package com.inversionControl;

public class TrackCoach implements Coach {

    private FortuneServices fortuneServices;

    public TrackCoach(FortuneServices fortuneServices) {
        this.fortuneServices = fortuneServices;
    }

    public TrackCoach(){}
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it! " + fortuneServices.getFortune();
    }
}
