package org.exampleConfig;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach{

    FortuneService fortuneService;

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    public SwimCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }

    @Override
    public String getTheExercise() {
        return "Swim 1000 meter as a warm up";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getYourFortune();
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
}
