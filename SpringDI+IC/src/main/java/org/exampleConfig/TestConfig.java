package org.exampleConfig;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        SwimCoach theCoach = context.getBean("swimCoach",SwimCoach.class);

        System.out.println(theCoach.getTheExercise());
        System.out.println(theCoach.getDailyFortune());

        System.out.println(theCoach.getEmail() + " in team:" + theCoach.getTeam());


        context.close();
    }
}
