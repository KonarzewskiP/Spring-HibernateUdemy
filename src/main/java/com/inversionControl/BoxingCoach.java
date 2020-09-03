package com.inversionControl;

public class BoxingCoach implements Coach {

    private FortuneServices fortuneServices;

    BoxingCoach(){

    }

    @Override
    public String getDailyWorkout() {
        return "Practising shadow boxing for 20 minutes.";
    }
}
