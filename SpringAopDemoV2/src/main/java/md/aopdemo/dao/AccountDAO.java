package md.aopdemo.dao;

import md.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("accountDAO")
public class AccountDAO {

    private String name;
    private String level;
    private List<Account> accountList;

    public String getName() {
        System.out.println(getClass() + "getter Name");
        return name;
    }

    public List<Account> findAccounts() {

        List<Account> ourList = new ArrayList<>();

        ourList.add(new Account("John","1000"));
        ourList.add(new Account("Anna","1100"));
        ourList.add(new Account("Alisa","12300"));

        return ourList;
    }

    public List<Account> findAccounts(boolean bool) {

        if(bool) {
            throw new RuntimeException("You have a new exception");
        }

        List<Account> ourList = new ArrayList<>();

        ourList.add(new Account("John","1000"));
        ourList.add(new Account("Anna","1100"));
        ourList.add(new Account("Alisa","12300"));

        return ourList;
    }

    public void setName(String name) {
        System.out.println(getClass() + "setter Name");
        this.name = name;
    }

    public String getLevel() {
        System.out.println(getClass() + "getter level");
        return level;
    }

    public void setLevel(String level) {
        System.out.println(getClass() + "getter level");
        this.level = level;
    }
    public void addAccount(Account account, boolean vipFlag) {

        System.out.println(getClass() + ": Adding account.");
    }


    public boolean doWork() {

        System.out.println(getClass()+ ": do my Work");

        return true;
    }
}
