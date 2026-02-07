package service.impl;

import domain.Account;
import domain.Customer;
import domain.TYPE;
import domain.Transaction;
import exception.AccountNotFoundException;
import exception.InsufficientsFundsException;
import exception.ValidationException;
import repository.AccountRepository;
import repository.CustomerRepository;
import repository.TransactionRepository;
import service.BankService;
import util.Validation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BankServiceImpl implements BankService {

    private final AccountRepository accountRepository = new AccountRepository();
    private final TransactionRepository transactionRepository = new TransactionRepository();
    private final CustomerRepository customerRepository = new CustomerRepository();

    private final Validation<String> validatename = name ->{
      if(name == null || name.isBlank()) throw new ValidationException("Name is null or blank");
    };

    private final Validation<String> validateemail = email ->{
        if(email == null || !email.contains("@")) throw new ValidationException("email is wrong");
    };

    private final Validation<String> validateType = type ->{
        if(type == null || !(type.equalsIgnoreCase("SAVINGS") || type.equalsIgnoreCase("CURRENT")))
            throw new ValidationException("type must be savings or current type");
    };
    @Override
    public String openAcount(String name, String email, String accounttype) {
        validatename.validate(name);
        validateemail.validate(email);
        validateType.validate(accounttype);
        //create customer
        String customerId = UUID.randomUUID().toString();

            Customer c = new Customer(customerId,name,email);
            customerRepository.save(c);
        //change later --> 10 + 1 = AC11,AC12,AC13,.....(AC will be the prefix)
       // String accountNumber = UUID.randomUUID().toString();

        //Account number genration
        String accountNumber = getAccountNumber();
        Account account = new Account(accountNumber, customerId,(double)0,accounttype);
        //Save

        accountRepository.save(account);

        return accountNumber;
    }

    @Override
    public List<Account> listAccounts() {
        return accountRepository.findAll().stream().sorted(Comparator.comparing(Account :: getAccountNumber))
                .collect(Collectors.toList());
    }

    @Override
    public void deposit(String accountNumber, Double amount, String note) {
        //To fetch the account number
        Account account = accountRepository.findByNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Account not found: " + accountNumber));
        account.setBalance(account.getBalance() + amount);
        Transaction transaction = new Transaction(UUID.randomUUID().toString(),TYPE.DEPOSIT,account.getAccountNumber(), amount, LocalDateTime.now(),note);
        transactionRepository.add(transaction);
    }

    @Override
    public void withdraw(String accountNumber, Double amount, String note) {
        //To fetch the account number
        Account account = accountRepository.findByNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Account not found: " + accountNumber));
        if(account.getBalance().compareTo(amount) < 0){
            throw new InsufficientsFundsException("Insufficient funds");// after this is triggred it will stop the logic rather than using the sout and printing a message

        }
        account.setBalance(account.getBalance() - amount);
        Transaction transaction = new Transaction(UUID.randomUUID().toString(),TYPE.WITHDRAW,account.getAccountNumber(), amount, LocalDateTime.now(),note);
        transactionRepository.add(transaction);
    }

    @Override
    public void transfer(String fromAcc, String toAcc, Double amount, String note) {
        if(fromAcc.equals(toAcc)){
            throw new ValidationException("Cannot Transfer to your own account");
        }
        //To fetch the account number(what if that account number is not found)
        Account from = accountRepository.findByNumber(fromAcc)
                .orElseThrow(() -> new AccountNotFoundException("Account not found: " + fromAcc));

        Account to = accountRepository.findByNumber(toAcc)
                .orElseThrow(() -> new AccountNotFoundException("Account not found: " + toAcc));

        if(from.getBalance().compareTo(amount) < 0){
            throw new InsufficientsFundsException("Insufficient funds");// after this is triggred it will stop the logic rather than using the sout and printing a message
        }
        //deduction of money from account
        from.setBalance(from.getBalance() - amount);
        //to account gets the money
        to.setBalance(to.getBalance() + amount);


        Transaction fromTransaction = new Transaction(UUID.randomUUID().toString(),TYPE.TRANSFER_OUT,from.getAccountNumber(), amount, LocalDateTime.now(),note);
        transactionRepository.add(fromTransaction);

        Transaction toTransaction = new Transaction(UUID.randomUUID().toString(),TYPE.TRANSFER_IN,to.getAccountNumber(), amount, LocalDateTime.now(),note);
        transactionRepository.add(toTransaction);

        System.out.println("Transfer successful");
    }

    @Override
    public List<Transaction> getStatement(String account) {
        //It gets all transactions of an account, sorts them by time, and returns them as a list.
        return transactionRepository.findByAccount(account).stream()
                .sorted(Comparator.comparing(Transaction::getTimestamp))
                .collect(Collectors.toList());
    }

    @Override
    public List<Account> searchAccountByCustomerName(String q) {
        //Prevents NullPointerException
        //Makes search case-insensitive
        String query = (q == null) ? "" : q.toLowerCase();
        List<Account> result = new ArrayList<>();
        for(Customer c : customerRepository.findAll())
        {
            if(c.getName().toLowerCase().contains(query))
            {
                result.addAll(accountRepository.findByCustomerId(c.getId()));
            }
        }
        result.sort(Comparator.comparing(Account :: getAccountNumber));
        return result;
    }

    //Logic to create account number
    private String getAccountNumber() {
        int size =  accountRepository.findAll().size()+1;
        String accountNumber = String.format("AC%06d",size );
        return accountNumber;
    }
}
