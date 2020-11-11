package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    // add a new method: findAccounts()

    public List<Account> findAccounts() {

        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account temp1 = new Account("Stephanie", "Pink");
        Account temp2 = new Account("Ross", "Gold");
        Account temp3 = new Account("Jenifer", "Platinum");

        // add them to our account list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);



        return myAccounts;

    }

    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
        System.out.println("VIP: " + vipFlag);
    }

    public void updateAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: UPDATING AN ACCOUNT\n");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
