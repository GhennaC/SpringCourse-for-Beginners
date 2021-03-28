package org.exampleConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

public interface Coach {

    public String getTheExercise();
    public String getDailyFortune();

}
