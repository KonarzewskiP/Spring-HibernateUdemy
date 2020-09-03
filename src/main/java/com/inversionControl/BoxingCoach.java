package com.inversionControl;

public class BoxingCoach implements Coach {

    //define a private field for the dependency
    private FortuneServices fortuneServices;

    BoxingCoach(FortuneServices theFortuneService) {
        fortuneServices = theFortuneService;
    }

    @Override
    public String getDailyFortune() {
        return fortuneServices.getFortune();
    }

    @Override
    public String getDailyWorkout()
    {
        return "Practising shadow boxing for 20 minutes.";
    }
}
