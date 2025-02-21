package menues;

import bank_service.Bank;

import java.util.Scanner;

import static menues.AccountSettingsMenu.accountSettingsMenu;

public class OkoliBankATM {
    static       Bank   bank;
    static final String BANK_NAME = "Okoli Bank Nigeria PLC";

    public static void main(String[] args) {
        bank = new Bank(BANK_NAME);
        mainMenu(successMessage("WELCOME TO OUR BANK"));
    }

    static void mainMenu(String prompt) {
        clearScreen();
        String menuPrompt = BANK_NAME + """
                
                Main Menu:
                1: Create Account
                2: Deposit
                3: Withdraw
                4: Transfer
                5: Check Balance
                6: Account Settings
                0: Exit
                
                """ + prompt + "\n>>>";

        int choice = inputInteger(menuPrompt);
        switch (choice) {
            case 1 -> createAccount();
            case 2 -> deposit();
            case 3 -> withdraw();
            case 4 -> transfer();
            case 5 -> checkBalance();
            case 6 -> accountSettings();
            case 0 -> exitBank();
            default -> mainMenu(errorMessage("Invalid selection: Try again"));
        }
    }

    private static void createAccount() {
        String firstName = inputText("Enter your first name: ");
        String lastName = inputText("Enter your last name: ");
        String pin = inputText("Enter your PIN code: ");
        int accountNumber;
        try {
            accountNumber = bank.createAccount(firstName, lastName, pin);
            mainMenu(successMessage("Account Created Successfully!\n") +
                    infoMessage(accountInfo(accountNumber)));
        } catch (IllegalArgumentException e) {
            mainMenu(errorMessage(e.getMessage()));
        }
    }

    private static void deposit() {
        int accountNumber = inputInteger("Enter the account number: ");
        int amount = inputInteger("Enter amount to increaseBy: ");
        try {
            bank.deposit(accountNumber, amount);
            mainMenu(successMessage(formatAmountOutput(amount) + " Deposit Successful"));
        } catch (IllegalArgumentException e) {
            mainMenu(errorMessage("Deposit Failed: " + e.getMessage()));
        }
    }

    private static void withdraw() {
        int accountNumber = inputInteger("Enter your account number: ");
        int amount = inputInteger("Enter amount to withdraw: ");
        String pin = inputText("Enter your PIN code: ");
        try {
            bank.withdraw(accountNumber, amount, pin);
            mainMenu(successMessage(formatAmountOutput(amount) + " Withdraw Successful"));
        } catch (IllegalArgumentException e) {
            mainMenu(errorMessage("Withdraw Failed" + e.getMessage()));
        }
    }

    private static void transfer() {
        int sourceAccountNumber = inputInteger("Enter source account number: ");
        int destinationAccountNumber = inputInteger("Enter destination account number: ");
        int amount = inputInteger("Enter amount: ");
        try {
            String transferPrompt = String.format("Transfer %s to %d (%s)%nTo proceed, please enter your PIN: ",
                    formatAmountOutput(amount), destinationAccountNumber, getFullName(destinationAccountNumber));
            String pin = inputText(infoMessage(transferPrompt));
            bank.transfer(sourceAccountNumber, destinationAccountNumber, amount, pin);
            mainMenu(successMessage(formatAmountOutput(amount) + " Transfer successful"));
        } catch (IllegalArgumentException e) {
            mainMenu(errorMessage("Transfer Failed" + e.getMessage()));
        }
    }

    private static void checkBalance() {
        int accountNumber = inputInteger("Enter account number: ");
        String pin = inputText("Enter your PIN: ");
        try {
            int balance = bank.checkBalance(accountNumber, pin);
            mainMenu(infoMessage(String.format("Your account balance is: %s", formatAmountOutput(balance))));
        } catch (IllegalArgumentException e) {
            mainMenu(errorMessage("Check Balance Failed" + e.getMessage()));
        }
    }

    private static void accountSettings() {
        int accountNumber = inputInteger("Enter account number: ");
        String greetings = "Hello " + getFullName(accountNumber);
        accountSettingsMenu(greetings, accountNumber);
    }

    static void exitBank() {
        System.exit(0);
    }

    private static String accountInfo(int accountNumber) {
        final String fullName = getFullName(accountNumber);
        return String.format("%s%nAccount number: %d%nAccount name: %s%n%s%n",
                "-".repeat(10), accountNumber, fullName, "-".repeat(10));
    }

    private static String getFullName(int accountNumber) {
        try {
            return bank.getAccountFirstName(accountNumber) + " " + bank.getAccountLastName(accountNumber);
        } catch (IllegalArgumentException e) {
            mainMenu(errorMessage(e.getMessage()));
        }
        return "";
    }

    private static void print(String text) {
        System.out.println(text);
    }

    static int inputInteger(String prompt) {
        print(prompt);
        Scanner scanner = new Scanner(System.in);
        try {
            String value = scanner.nextLine();
            value = value.replaceAll("\\s+", "")
                    .replaceAll("[_,]", "");
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            print(errorMessage("Value should be an integer, only (',' and '_') are acceptable separator"));
            return inputInteger(prompt);
        }
    }

    static String inputText(String prompt) {
        print(prompt);
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        if (value.isEmpty()) {
            print(errorMessage("Your input is empty, try again"));
            return inputText(prompt);
        } else return value;
    }

    static void clearScreen() {
        print("\033[H\033[2J");
    }

    private static String formatAmountOutput(int balance) {
        String balanceStr = "" + balance;
        StringBuilder result = new StringBuilder();
        for (int i = balanceStr.length() - 1, count = 1; i >= 0; i--, count++) {
            result.insert(0, balanceStr.charAt(i));
            if (count % 3 == 0) {
                result.insert(0, ",");
            }
        }
        return "₦ " + result;
    }

    static String errorMessage(String prompt) {
        return "\033[31m" + prompt + "\033[0m";
    }

    static String successMessage(String prompt) {
        return "\033[32m" + prompt + "\033[0m";
    }

    static String infoMessage(String prompt) {
        return "\033[33m" + prompt + "\033[0m";
    }
}
