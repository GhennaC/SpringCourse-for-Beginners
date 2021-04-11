package md.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(0)
@Aspect
@Component
public class BeforeAspect {

    @Pointcut("execution(* md.aopdemo.dao.*.add*(..))")
    private void forDao() {}

    @Pointcut("execution(* md.aopdemo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* md.aopdemo.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDao() && !(getter() || setter())")
    public void performApiAnalytics() {
    }

    @Before("performApiAnalytics()")
    public void doALL(){
        System.out.println("=>>> Performing Api analytics");
    }
}
