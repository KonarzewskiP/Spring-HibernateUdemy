package spring_demo_annotations;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneServices {

    @Override
    public String getFortune() {
        return null;
    }
}
