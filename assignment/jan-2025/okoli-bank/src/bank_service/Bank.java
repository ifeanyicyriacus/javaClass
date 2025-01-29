package bank_service;

import java.util.HashMap;

public class Bank {
    private final String name;
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

    public int createAccount(String firstName, String lastName, String pin) {
        Account newAccount = new Account(generateUniqueAccountNumber(), firstName, lastName, pin);
        int newAccountNumber = newAccount.getAccountNumber();
        accounts.put(newAccountNumber, newAccount);
        return newAccountNumber;
    }

    public String getAccountFirstName(int accountNumber) {
        return accounts.get(accountNumber).getFirstName();
    }

    public String getAccountLastName(int accountNumber) {
        return accounts.get(accountNumber).getLastName();
    }

    private int generateUniqueAccountNumber() {
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
        if (sourceAccountNumber == destinationAccountNumber) throw new IllegalArgumentException("Source account number is the same as the destination account number");

        Account source = accounts.get(sourceAccountNumber);
        Account destination = accounts.get(destinationAccountNumber);

        if (source == null) throw new IllegalArgumentException("Source account not found");
        if (destination == null) throw new IllegalArgumentException("Destination account not found");

        try {
            source.withdraw(amount, sourceAccountPin);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Transfer Unsuccessful "+ e.getMessage());
        }

        try{
            destination.deposit(amount);
        } catch (IllegalArgumentException err) {
            source.deposit(amount);
            throw new IllegalArgumentException("Transfer Unsuccessful: " + err.getMessage());
        }
    }
}
