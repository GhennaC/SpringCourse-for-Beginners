package md.aopdemo;

import md.aopdemo.config.DemoConfig;
import md.aopdemo.dao.AccountDAO;
import md.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring cont
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);

        // Testing @Before annot
        Account acc = new Account();
        acc.setLevel("1000");
        acc.setName("Vasea");
        accountDAO.addAccount(acc, true);

        membershipDAO.goToSleep();

        // Testing @AfterReturn annot
        List<Account> list = accountDAO.findAccounts();
        System.out.println("\n AfterReturning Demo in Main class");
        System.out.println(list);


        // Testing @AfterThrowing annot
        try {
            boolean tripWire = true;
            list = accountDAO.findAccounts(tripWire);
            System.out.println("Blablabla");

        }catch (Exception exception) {
            System.out.println("\nMain : caught expept: "+exception);
        }

        // close the context
        context.close();

    }
}
