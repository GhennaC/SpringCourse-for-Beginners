package md.aopdemo.aspect;


import md.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class AfterAspect {

    @AfterReturning(
            pointcut = "execution(* md.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint,
                                                 List<Account> result) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=>>>> After returning method: " + method);

        System.out.println("=>>>> result is: " + result);

    }

    @AfterThrowing(
            pointcut = "execution(* md.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exception")
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint,
                                                 Throwable exception) {
        System.out.println("<=== your exception was thrown:"+ exception);
    }

    @After("execution(* md.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinally(JoinPoint joinPoint) {

        System.out.println("<==== You have finished you method");
    }

}
