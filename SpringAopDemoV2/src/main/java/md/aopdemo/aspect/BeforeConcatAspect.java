package md.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(-1)
@Aspect
@Component
public class BeforeConcatAspect {

    // this is where we add all of our related advices for logging

    @Before("md.aopdemo.aspect.BeforeAspect.performApiAnalytics()")
    public  void beforeAddAccount(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        Object[] args = joinPoint.getArgs();

        for(Object i : args)
            System.out.println(i);

        System.out.println("\n<<< "+methodSignature+" >>>\n");


        System.out.println("\nAdd account");
    }



}
