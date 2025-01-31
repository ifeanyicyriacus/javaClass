package bank_service;

public class Account {
    private final int    accountNumber;
    private       String firstName;
    private       String lastName;
    private       String pin;
    private       int    balance;

    public Account(int accountNumber, String firstName, String lastName, String pin) {
        if (accountNumber < 1) throw new IllegalArgumentException("Please Enter a valid Account number");
        this.accountNumber = accountNumber;
        if (firstName.isEmpty()) throw new IllegalArgumentException("First name cannot be empty");
        this.firstName = firstName;
        if (lastName.isEmpty()) throw new IllegalArgumentException("Last name cannot be empty");
        this.lastName = lastName;
        if (pin.isEmpty()) throw new IllegalArgumentException("Pin cannot be empty");
        this.pin = pin;
    }

    public boolean exist() {
        return true;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setFirstName(String firstName, String pin) {
        if (this.pin.equals(pin)) {
            this.firstName = firstName;
        } else throw new IllegalArgumentException("Incorrect PIN");
    }

    public void setLastName(String lastName, String pin) {
        if (this.pin.equals(pin)) {
            this.lastName = lastName;
        } else throw new IllegalArgumentException("Incorrect PIN");
    }

    public void updatePin(String oldPin, String newPin) {
        if (pin.equals(oldPin)) {
            this.pin = newPin;
        } else throw new IllegalArgumentException("Incorrect PIN");
    }

    public int checkBalance(String pin) {
        if (this.pin.equals(pin)) {
            return balance;
        } else throw new IllegalArgumentException("Incorrect PIN");
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        } else throw new IllegalArgumentException("Amount can't be zero or negative");
    }

    public void withdraw(int amount, String pin) {
        if (pin.equals(this.pin)) {
            if (amount > balance) {
                throw new IllegalArgumentException("Insufficient Balance");
            } else if (amount <= 0) {
                throw new IllegalArgumentException("Withdrawal amount can't be negative");
            } else {
                balance -= amount;
            }
        } else throw new IllegalArgumentException("Incorrect PIN");
    }


}
