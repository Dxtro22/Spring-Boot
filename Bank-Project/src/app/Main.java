package app;

import service.BankService;
import service.impl.BankServiceImpl;

import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankService bankService = new  BankServiceImpl();
        System.out.println("Welcome to Console Bank : ");
        //Printing all the maping features
        boolean val = true;
        while(val){
            System.out.println("""
                1) Open Account
                2) Deposit
                3) Withdrawal
                4) Transfer
                5) Account Statement
                6) List Accounts
                7) Search Accounts by Customer Name
                0) Exit
                """);
            System.out.print("CHOOSE: ");
            String choice = scanner.nextLine().trim();//helps to read input and remove the trailing space
            System.out.println("CHOICE: "+choice);

            switch (choice){
                case "1" ->{
                    openAccount(scanner,bankService);
                }
                case "2" ->{
                    deposit(scanner, bankService);
                }
                case "3" ->{
                    withdraw(scanner,bankService);
                }
                case "4" ->{
                    transfer(scanner, bankService);
                }
                case "5" ->{
                    statements(scanner,bankService);
                }
                case "6" ->{
                    listAccounts(scanner,bankService );
                }
                case "7" ->{
                    searchAccounts(scanner,bankService);
                }
                case "0" ->{
                    val=false;
                }

            }
        }


    }

    private static void openAccount(Scanner scanner,BankService bankService) {
        System.out.println("Customer Name :");
        String name = scanner.nextLine().trim();
        System.out.println("Customer Email :");
        String email = scanner.nextLine().trim();
        System.out.println("Account Type (CURRENT/SAVINGS):");
        String type = scanner.nextLine().trim();
        System.out.println("Initial Deposit Amount (OPTIONAL , Enter 0 for blank amount) :");
        String amountStr = scanner.nextLine().trim();
        if(amountStr.isBlank())amountStr = "0";
        Double initial = Double.valueOf(amountStr);
        String accountNumber = bankService.openAcount(name,email,type);
        if(initial>0){
            bankService.deposit(accountNumber,initial,"Initial Deposit");
        }
        System.out.println("Account Opened successfully " + accountNumber);
    }

    private static void deposit(Scanner scanner, BankService bankService) {
        System.out.println("Account Number :");
        String accountNumber = scanner.nextLine().trim();
        System.out.println("Amount to Deposit :");
        Double amount = Double.valueOf(scanner.nextLine().trim());
        bankService.deposit(accountNumber,amount,"Deposit");
        System.out.println("Deposited");

    }

    private static void withdraw(Scanner scanner,BankService bankService) {
        System.out.println("Account Number :");
        String accountNumber = scanner.nextLine().trim();
        System.out.println("Amount to Deposit :");
        Double amount = Double.valueOf(scanner.nextLine().trim());
        bankService.withdraw(accountNumber,amount,"Withdrawl ");
        System.out.println("Withdrawn ");
    }

    private static void transfer(Scanner scanner,BankService bankService) {
        System.out.println("Sender Account Number :");
        String from = scanner.nextLine().trim();
        System.out.println("Reciver Account Number :");
        String to = scanner.nextLine().trim();
        System.out.println("Amount to Transfer :");
        Double amount = Double.valueOf(scanner.nextLine().trim());
        bankService.transfer(from,to ,amount,"Transfer ");
    }

    private static void statements(Scanner scanner,BankService bankService) {
        System.out.println("Account Number :");
        String account = scanner.nextLine().trim();
        bankService.getStatement(account).forEach(t -> System.out.println(t.getTimestamp() + " | " + t.getType()  + " | "  + t.getAmount() + t.getType()  + " | " + t.getNote()));


    }

    private static void listAccounts(Scanner scanner,BankService bankService) {
        bankService.listAccounts().forEach(a ->{
            System.out.println(a.getAccountNumber() + " | " +  a.getAccountType() + " | " +  a.getBalance());
        });
    }

    private static void searchAccounts(Scanner scanner,BankService bankService) {
        System.out.println("Customer Name :");
        String q = scanner.nextLine().trim();
        bankService.searchAccountByCustomerName(q).forEach(account ->
                System.out.println(account.getAccountNumber() + " | "+ account.getAccountType()+ " | "+ account.getBalance())
        );

    }
}
