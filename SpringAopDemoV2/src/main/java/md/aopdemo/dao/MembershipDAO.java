package md.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addAccount() {

        System.out.println("Add account from Membership");
        return true;
    }


    public  void goToSleep() {

        System.out.println("I'm going to sleep");
    }

}
