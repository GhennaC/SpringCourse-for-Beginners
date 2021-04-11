package md.aopdemo;

import md.aopdemo.config.DemoConfig;
import md.aopdemo.dao.AccountDAO;
import md.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring cont
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);

        // call the business method
        accountDAO.addAccount(new Account(), true);

        accountDAO.doWork();

        // call it again
        System.out.println("One more time:");
        membershipDAO.addAccount();

        membershipDAO.goToSleep();

        // close the context
        context.close();

    }
}
