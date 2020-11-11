package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccDAO =
                context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> theAccounts = null;
        try{
            // add a boolean flag to simulate exception
            boolean tripwire = true;
            theAccounts = theAccDAO.findAccounts(tripwire);

        }catch (Exception exc){
            System.out.println("\n\nMain Program ... caught exception -> " + exc);
        }

        // display the accounts
        System.out.println("\n\nMain Program: After_Throwing_Demo_App".toUpperCase());
        System.out.println("--------------------------------------------------");

        System.out.println(theAccounts);

        System.out.println("\n");

        //close the context
        context.close();

    }
}
