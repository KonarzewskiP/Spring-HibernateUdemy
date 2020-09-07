package com.inversionControl;

public class HappyFortuneService implements  FortuneServices{
    @Override
    public String getFortune() {
        String[] fortunes = {"Today is your lucky day!","You got it, just do it!","Never never give up!"};

        int number = (int) (Math.random() * 3);
        System.out.println(number+" <--");
        return fortunes[number];
    }
}
