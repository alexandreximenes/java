package br.com.springaopexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Slf4j
public class SpringaopexampleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringaopexampleApplication.class, args);
        AccountService accountService = ctx.getBean("accountService", AccountServiceImpl.class);
        accountService.updateAccountBalance(new Account("12345678910", "5000L", "Money Transfer"), 5000L);


        Account account;
        try{
            account = accountService.getAccountByCustomerId(null);
            if(account != null){
                log.info(account.getAccountNumber() + "\t" + account.getDescription());
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }

    }

}
