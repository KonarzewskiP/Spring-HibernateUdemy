package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start wth an @Before advice

    //"execution(public void addAccount())" <-- is a Pointcut expression
    //Run this code BEFORE - target object method: "public void addAccount()"
    //This method will run for any class that have addAccount() method
//    @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
//    @Before("execution(public void addAccount())")
//    @Before("execution(public void add*())")
//    @Before("execution(void add*())")
//    @Before("execution(* add*())")
//    @Before("execution(* addAccount(com.luv2code.aopdemo.Account))")
//    @Before("execution(* addAccount(com.luv2code.aopdemo.Account, ..))")
//    @Before("execution(* addAccount(Account))") //  <-- DOESN'T WORK !!!!
//    @Before("execution(* add*(..))")
    @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
//    @Before("execution(public void updateAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=======>>> Executing @Before advice on addAccount()");
    }
}
