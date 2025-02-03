package bank_service;

public class Account {
    private final int    accountNumber;
    private       String firstName;
    private       String lastName;
    private       String pin;
    private       int    balance;

    public Account(int accountNumber, String firstName, String lastName, String pin) {
        try {
            if (accountNumber < 1) throw new IllegalArgumentException("Please Enter a valid Account number");
            this.accountNumber = accountNumber;
            setFirstName(firstName);
            updateLastName(lastName);
            setPin(pin);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Account creation failed: " + e.getMessage());
        }
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

    private void setFirstName(String firstName) {
        if (firstName.isEmpty()) throw new IllegalArgumentException("First name cannot be empty");
        this.firstName = firstName;
    }

    private void updateLastName(String lastName) {
        if (lastName.isEmpty()) throw new IllegalArgumentException("Last name cannot be empty");
        this.lastName = lastName;
    }

    private void setPin(String pin) {
        if (pin.isEmpty()) throw new IllegalArgumentException("Pin cannot be empty");
        this.pin = pin;
    }

    public void updateFirstName(String firstName, String pin) {
        if (this.pin.equals(pin)) {
            setFirstName(firstName);
        } else throw new IllegalArgumentException("Incorrect PIN");
    }

    public void updateLastName(String lastName, String pin) {
        if (this.pin.equals(pin)) {
            updateLastName(lastName);
        } else throw new IllegalArgumentException("Incorrect PIN");
    }

    public void updatePin(String oldPin, String newPin) {
        if (pin.equals(oldPin)) {
            setPin(newPin);
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
        } else throw new IllegalArgumentException("Deposit amount can not be zero or negative");
    }

    public void withdraw(int amount, String pin) {
        if (pin.equals(this.pin)) {
            if (amount > balance) {
                throw new IllegalArgumentException("Insufficient Balance");
            } else if (amount <= 0) {
                throw new IllegalArgumentException("Withdrawal amount can not be zero or negative");
            } else {
                balance -= amount;
            }
        } else throw new IllegalArgumentException("Incorrect PIN");
    }


}
