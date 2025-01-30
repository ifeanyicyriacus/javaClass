package bank_service;

import java.util.HashMap;

public class Bank {
    private final  String                    name;
    private final  HashMap<Integer, Account> accounts       = new HashMap<>();
    private static int                       accountCounter = 1;

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
        Account account = tryGetAccount(accountNumber);
        return account.getFirstName();
    }

    private Account tryGetAccount(int accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account number (" + accountNumber + ") does not exist");
        }
        return account;
    }

    public String getAccountLastName(int accountNumber) {
        Account account = tryGetAccount(accountNumber);
        return account.getLastName();
    }


    private int generateUniqueAccountNumber() {
        return accountCounter++;
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public void deposit(int accountNumber, int amount) {
        Account account = tryGetAccount(accountNumber);
        account.deposit(amount);
    }

    public int checkBalance(int accountNumber, String pin) {
        Account account = tryGetAccount(accountNumber);
        return account.checkBalance(pin);
    }

    public void withdraw(int accountNumber, int amount, String pin) {
        Account account = tryGetAccount(accountNumber);
        account.withdraw(amount, pin);
    }

    public void transfer(int sourceAccountNumber, int destinationAccountNumber, int amount, String sourceAccountPin) {
        if (sourceAccountNumber == destinationAccountNumber)
            throw new IllegalArgumentException("Source account number is the same as the destination account number");

        Account source = tryGetAccount(sourceAccountNumber);
        Account destination = tryGetAccount(destinationAccountNumber);

        try {
            source.withdraw(amount, sourceAccountPin);
            destination.deposit(amount);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Transfer Unsuccessful " + e.getMessage());
        }
    }

    public void resetPIN(int accountNumber, String oldPIN, String newPIN) {
        Account account = tryGetAccount(accountNumber);
        account.updatePin(oldPIN, newPIN);
    }

    public void updateFirstName(int accountNumber, String newFirstName, String correctPIN) {
        Account account = tryGetAccount(accountNumber);
        account.setFirstName(newFirstName, correctPIN);
    }

    public void updateLastName(int accountNumber, String newLastName, String correctPIN) {
        Account account = tryGetAccount(accountNumber);
        account.setLastName(newLastName, correctPIN);
    }
}
