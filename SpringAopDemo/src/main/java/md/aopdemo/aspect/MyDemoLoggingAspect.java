package md.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // @Before adv
    // @Before("execution(public void md.aopdemo.dao.AccountDAO.addAccount())")
    // @Before("execution(public void add*())")
    @Before("execution(* md.aopdemo.dao.*.*(..))")
    public  void beforeAddAccount() {

        System.out.println("Add account");
    }

}
