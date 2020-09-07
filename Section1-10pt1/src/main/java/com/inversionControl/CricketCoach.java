package com.inversionControl;

public class CricketCoach implements Coach{
    //add new email and team values for xml injection
    private String emailAddress;
    private String team;

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("CricketCoach: inside setter method - setEmailAddress()");
        this.emailAddress = emailAddress;

    }

    public void setTeam(String team) {
        System.out.println("CricketCoach: inside setter method - setTeam()");
        this.team = team;
    }

    private FortuneServices theFortuneService;

    public CricketCoach(){
        System.out.println("CricketCoach: inside no-arg constructor");
    }

    public void setFortuneService(FortuneServices theFortuneService){
        System.out.println("CricketCoach: inside setter method - setFortuneService()");
        this.theFortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {
        return "Cricket coach says: "+theFortuneService.getFortune();
    }
}
