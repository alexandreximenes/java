package br.com.springaopexample;

public interface AccountService {
    void updateAccountBalance(Account account, Long amount);
    Account getAccountByCustomerId(String customerId) throws Exception;
}
