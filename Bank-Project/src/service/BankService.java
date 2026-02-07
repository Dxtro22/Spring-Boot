package service;

import domain.Account;
import domain.Transaction;

import java.util.List;
import java.util.Map;

public interface BankService {
    String openAcount(String name,String email,String Accounttype);
    List<Account> listAccounts();


    void deposit(String accountNumber, Double amount, String note);

    void withdraw(String accountNumber, Double amount, String withdrawl);

    void transfer(String from, String to, Double amount, String transfer);

    List<Transaction> getStatement(String account);

    List<Account>  searchAccountByCustomerName(String q);
}
