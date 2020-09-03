package com.inversionControl;

public class HappyFortuneService implements  FortuneServices{
    @Override
    public String getFortune() {
        return "Today is your lucky day!";
    }
}
