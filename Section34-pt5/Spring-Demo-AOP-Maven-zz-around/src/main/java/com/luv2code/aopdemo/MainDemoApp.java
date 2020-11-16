package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccDAO =
                context.getBean("accountDAO", AccountDAO.class);

        // get the membership bean from spring container
        MembershipDAO theMembershipDAO =
                context.getBean("membershipDAO", MembershipDAO.class);

        // call the Account business method
        Account myAccount = new Account();
        myAccount.setName("Tony Stark");
        myAccount.setLevel("Diamond");
        theAccDAO.addAccount(myAccount, true);
        theAccDAO.doWork();

        // call the accountDao getter/setter methods
        theAccDAO.setName("foobar");
        theAccDAO.setServiceCode("silver");

        String name = theAccDAO.getName();
        String code = theAccDAO.getServiceCode();


        // call the Membership business method
        theMembershipDAO.addSillyMember();
        theMembershipDAO.goToSleep();

        // do it again!
        System.out.println("\n let's call it again!\n");
        theAccDAO.addAccount(myAccount, false);
        theMembershipDAO.addSillyMember();

        //close the context
        context.close();

    }
}
