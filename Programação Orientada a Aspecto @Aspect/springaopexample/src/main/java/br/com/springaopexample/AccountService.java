package br.com.springaopexample;

public interface AccountService {
    default Account updateAccountBalance(Account account, Long amount){
        return account;
    };
    Account getAccountByCustomerId(String customerId) throws Exception;
}
