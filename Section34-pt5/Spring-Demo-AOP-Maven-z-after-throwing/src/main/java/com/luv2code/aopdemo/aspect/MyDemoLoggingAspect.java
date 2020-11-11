package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(-1)
public class MyDemoLoggingAspect {

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
   public void afterThrowingFindAccountAdvice(
            JoinPoint theJoinPoint, Throwable theExc){

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n---->>> Executing @AfterThrowing on method: ".toUpperCase() + method);
        // log the exception
        System.out.println("\n----->>> The exception is: ".toUpperCase() + theExc);
   }

    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(
            JoinPoint theJoinPoint, List<Account> result) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n======>>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n======>>> result is: " + result);

        // let's post-process the data ... let's modify it

        // convert the account names to uppercase
        convertAccountNameToUpperCase(result);

        System.out.println("\n======>>> result AFTER MODIFICATION: " + result);


    }

    private void convertAccountNameToUpperCase(List<Account> result) {
        // loop through accounts

        for (Account tempAccount : result) {
            // get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperName);
        }


    }

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=======>>> Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature metSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + metSignature);

        // display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        // loop thru args
        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account) {
                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("Account level: " + theAccount.getLevel());
                System.out.println("--------------------------------------------------");
            }
        }
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }

}
