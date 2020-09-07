package spring_demo_annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// searching for right components in package "spring_demo_annotations"
//@ComponentScan("spring_demo_annotations")
// LOAD PROPERTIES FILE IN SPRING CONFIG --- INJECTING VALUES FROM PROPERTIES FILE
@PropertySource("classpath:sport.properties")
public class SportConfig {

    // define ben for our sad fortune service
    //  THE METHOD NAME IS THE "BEAN ID"
    @Bean
    public FortuneServices sadFortuneService(){
        return new SadFortuneService();
    }

    @Bean
    public FortuneServices randomFortuneService(){
        return new RandomFortuneService();
    }

    // define bean for our swim coach And inject dependency
    //  THE METHOD NAME IS THE "BEAN ID"
    @Bean
    public Coach rugbyCoach(){
        return new RugbyCoach(sadFortuneService());
    }

//    @Bean
//    public Coach tennisCoach(){
//        return new TennisCoach(randomFortuneService());
//    }
}
