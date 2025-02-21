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

    public int createAccount(String firstName, String lastName, String pin) {

        Account newAccount = new Account(generateUniqueAccountNumber(), firstName, lastName, pin);
        int newAccountNumber = newAccount.getAccountNumber();
        accounts.put(newAccountNumber, newAccount);
        return newAccountNumber;
    }

    public String getAccountFirstName(int accountNumber) {
        Account account = getAccount(accountNumber);
        return account.getFirstName();
    }

    private Account getAccount(int accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account number (" + accountNumber + ") does not exist");
        }
        return account;
    }

    public String getAccountLastName(int accountNumber) {
        Account account = getAccount(accountNumber);
        return account.getLastName();
    }


    private int generateUniqueAccountNumber() {
        return accountCounter++;
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public void deposit(int accountNumber, int amount) {
        Account account = getAccount(accountNumber);
        account.increaseBy(amount);
    }

    public int checkBalance(int accountNumber, String pin) {
        Account account = getAccount(accountNumber);
        return account.checkBalance(pin);
    }

    public void withdraw(int accountNumber, int amount, String pin) {
        Account account = getAccount(accountNumber);
        account.withdraw(amount, pin);
    }

    public void transfer(int sourceAccountNumber, int destinationAccountNumber, int amount, String sourceAccountPin) {
        if (sourceAccountNumber == destinationAccountNumber)
            throw new IllegalArgumentException("Source account number is the same as the destination account number");

        Account source = getAccount(sourceAccountNumber);
        Account destination = getAccount(destinationAccountNumber);

        try {
            source.withdraw(amount, sourceAccountPin);
            destination.increaseBy(amount);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Transfer Unsuccessful " + e.getMessage());
        }
    }

    public void resetPIN(int accountNumber, String oldPIN, String newPIN) {
        Account account = getAccount(accountNumber);
        account.updatePin(oldPIN, newPIN);
    }

    public void updateFirstName(int accountNumber, String newFirstName, String correctPIN) {
        Account account = getAccount(accountNumber);
        account.updateFirstName(newFirstName, correctPIN);
    }

    public void updateLastName(int accountNumber, String newLastName, String correctPIN) {
        Account account = getAccount(accountNumber);
        account.updateLastName(newLastName, correctPIN);
    }
}
