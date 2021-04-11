package md.aopdemo.dao;

import md.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component("accountDAO")
public class AccountDAO {

    public void addAccount(Account account, boolean vipFlag) {

        System.out.println(getClass() + ": Adding account.");
    }


    public boolean doWork() {

        System.out.println("Im doing my Work.");

        return true;
    }
}
