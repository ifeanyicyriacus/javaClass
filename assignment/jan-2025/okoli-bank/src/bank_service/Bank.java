package bank_service;

import java.util.HashMap;

public class Bank {
    private String name;
    private final HashMap<Integer, Account> accounts = new HashMap<>();
    private static int accountCounter = 1;

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean exist() {
        return true;
    }

    public Account createAccount(String firstName, String lastName, String pin) {
        Account newAccount = new Account(generateAccountUniqueAccountNumber(), firstName, lastName, pin);
        accounts.put(newAccount.getAccountNumber(), newAccount);
        return accounts.get(newAccount.getAccountNumber());
    }

    private int generateAccountUniqueAccountNumber() {
        return accountCounter++;
    }

    public int getNumberOfAccounts() {
            return accounts.size();
    }

    public void deposit(int accountNumber, int amount) {
        Account account = accounts.get(accountNumber);
        account.deposit(amount);
    }

    public int checkBalance(int accountNumber, String pin) {
        return accounts.get(accountNumber).checkBalance(pin);
    }

    public void withdraw(int accountNumber, int amount, String pin) {
        Account account = accounts.get(accountNumber);
        account.withdraw(amount, pin);
    }

    public void transfer(int sourceAccountNumber, int destinationAccountNumber, int amount, String sourceAccountPin) {
        Account source;
        Account destination;

        source = accounts.get(sourceAccountNumber);
        destination = accounts.get(destinationAccountNumber);
        source.withdraw(amount, sourceAccountPin);
        destination.deposit(amount);
    }
}
