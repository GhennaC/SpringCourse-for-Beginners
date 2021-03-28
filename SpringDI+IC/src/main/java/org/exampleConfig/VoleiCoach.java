package org.exampleConfig;

import org.springframework.stereotype.Component;

@Component
public class VoleiCoach implements Coach{

    private FortuneService fortuneService;
    @Override
    public String getTheExercise() {
        return "Bate mingea";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
