package org.exampleConfig;

public class SadFortuneService implements FortuneService{

    @Override
    public String getYourFortune() {
        return "Try again another day, i'm sorry :(.";
    }
}
