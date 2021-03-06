package br.com.springaopexample;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class AccountServiceAspect {

//    @Before(value = "execution(* br.com.springaopexample.AccountServiceImpl.*(..)) and args(account,..) ")
//    public void beforeAdvice(JoinPoint joinPoint, Account account){
//
//        log.info("---------------------------");
//        log.info("Before method getSignature: " + joinPoint.getSignature());
//        log.info("Audit account access: " + account.getAccountNumber() );
//        log.info("---------------------------");
//    }
//
//    @AfterReturning(value = "execution(* br.com.springaopexample.AccountServiceImpl.*(..)) ", returning = "account")
//    public void afterReturningAdvice(JoinPoint joinPoint, Account account){
//        log.info("***************************");
//        log.info("After returning method: " + joinPoint.getSignature());
//        log.info("Account: " + account);
//        log.info("***************************");
//    }
//
//    @AfterThrowing(value = "execution(* br.com.springaopexample.AccountServiceImpl.*(..)) ", throwing = "ex")
//    public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex){
//        log.info("###########################");
//        log.info("After throwing exception in method: " + joinPoint.getSignature());
//        log.info("Exception message: " + ex.getMessage());
//        log.info("Exception is: " + ex);
//        log.info("###########################");
//    }

    @Around(value = "execution(* br.com.springaopexample.AccountServiceImpl.updateAccount*(..)) ")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        log.info("---------- Before method around " + joinPoint.getSignature());

        long sTime = System.currentTimeMillis();
        Object object = null;
        try {
            object = joinPoint.proceed();
            if (object instanceof Account) {
                Account account = (Account) object;
                log.info("---------- " + account);
            }
        } catch (Throwable e) {
            log.info("---------- ", e.getMessage(), e);
        }
        log.info("After method around " + joinPoint.getSignature());
        long eTime = System.currentTimeMillis();

        log.info("---------- Total execution time taken by Method " + joinPoint.getSignature() + " is " + (eTime - sTime) + " ms");

        return object;
    }


}
