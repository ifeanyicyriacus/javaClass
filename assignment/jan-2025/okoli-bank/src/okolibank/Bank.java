package okolibank;

public class Bank {
    private static int numberOfAccounts = 0;

    public boolean exist() {
        return true;
    }

    public Account createAccount(String firstName, String lastName, String pin) {
        numberOfAccounts++;
        return new Account(100, firstName, lastName, pin);
    }

    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }


}
