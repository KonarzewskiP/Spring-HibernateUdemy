package spring_demo_annotations;

public class SadFortuneService implements FortuneServices{

    @Override
    public String getFortune() {
        return "Today is a sad day";
    }
}
