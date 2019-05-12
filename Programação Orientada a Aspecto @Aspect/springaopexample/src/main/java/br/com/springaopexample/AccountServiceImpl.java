package br.com.springaopexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service("accountService")
@Slf4j
public class AccountServiceImpl implements AccountService{

    public Account updateAccountBalance(Account account, Long amount) {
        log.info("Account No.:" + account.getAccountNumber() + " Amount: " + amount);
        return account;
    }


    private static Map<String, Account> map = null;

    static {
        map = new HashMap<>();
        map.put("001", new Account("77888", "1000", "saving account"));
        map.put("002", new Account("88877", "2000","current account"));
    }

    @Override
    public Account getAccountByCustomerId(String customerId) throws Exception {
        if(customerId == null)
            throw new Exception("customer id is invalid");

        Account account = null;
        Set<Map.Entry<String, Account>> entrySet = map.entrySet();
        for(Map.Entry<String, Account> entry : entrySet){
            if(entry.getKey().equals(customerId)){
                account = entry.getValue();
            }
        }
        return account;
    }


}
