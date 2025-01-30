import bank_service.Bank;

import java.util.Scanner;

public class OkoliBankUSSD {
    private static       Bank   bank;
    private static final String BANK_NAME = "Okoli Bank Nigeria PLC";

    public static void main(String[] args) {
        bank= new Bank(BANK_NAME);
        mainMenu("WELCOME TO OUR BANK");
    }

    private static void mainMenu(String prompt) {
        clearScreen();
        String menuPrompt = BANK_NAME + """
                
                Main Menu:
                1: Create Account
                2: Deposit
                3: Withdraw
                4: Transfer
                5: Check Balance
                6: Get Mini Statement
                7: Account Settings
                0: Exit
                
                """ + prompt +"\n>>>";

        int choice = inputNumber(menuPrompt);
        switch (choice) {
            case 1 -> createAccount();
            case 2 -> deposit();
            case 3 -> withdraw();
            case 4 -> transfer();
            case 5 -> checkBalance();
            case 6 -> getMiniStatement();
            case 7 -> updateProfile();
            case 0 -> exitBank();
            default -> mainMenu("Invalid selection: Try again");
        }
    }

    private static void clearScreen() {
        print("\033[H\033[2J");
    }

    private static void getMiniStatement() {
        mainMenu("Mini Statement (Coming soon)");
    }

    private static void updateProfile() {
        int accountNumber = inputNumber("Enter account number: ");
        String greetings = "Hello " + getFullName(accountNumber);
        updateProfileMenu(greetings, accountNumber);
    }

    private static void updateProfileMenu(String prompt, int accountNumber) {
        clearScreen();
        String menuPrompt = BANK_NAME + """
                
                Main Menu/Update Profile:
                1: Change First Name
                2: Change Last Name
                3: Reset PIN
                0: |<- Go back to Main Menu
                
                """ + prompt +"\n>>>";

        int choice = inputNumber(menuPrompt);
        switch (choice) {
            case 1 -> updateFirstName(accountNumber);
            case 2 -> updateLastName(accountNumber);
            case 3 -> resetPin();
            case 0 -> mainMenu(prompt);
            default -> updateProfileMenu("Invalid selection: Try again", accountNumber);
        }
    }

    private static void updateLastName(int accountNumber) {
        String newLastName = inputText("Enter new last name: ");
        String pin = inputText("Enter new pin: ");
        bank.updateLastName(accountNumber, newLastName, pin);
        updateProfileMenu("Last Name set to: " + newLastName, accountNumber);
    }

    private static void updateFirstName(int accountNumber) {
        String newFirstName = inputText("Enter new first name: ");
        String pin = inputText("Enter new pin: ");
        bank.updateFirstName(accountNumber, newFirstName, pin);
        updateProfileMenu("First Name set to: " + newFirstName, accountNumber);
    }

    private static void resetPin() {
        int accountNumber = inputNumber("Enter account number: ");
        String currentPin = inputText("Enter your PIN: ");
        String newPin = inputText("Enter your new PIN: ");
        bank.resetPIN(accountNumber, currentPin, newPin);
        mainMenu("Your new PIN has been reset");
    }

    private static void checkBalance() {
        int accountNumber = inputNumber("Enter account number: ");
        String pin = inputText("Enter your PIN: ");
        int balance = bank.checkBalance(accountNumber, pin);
        mainMenu(String.format("Your account balance is: %d", balance));
    }

    private static void exitBank() {
        System.exit(0);
    }

    private static void transfer() {
//        go and take notice of two bank prompt ussd and mobile app
        int sourceAccountNumber = inputNumber("Enter source account number: ");
        int destinationAccountNumber = inputNumber("Enter destination account number: ");
        int amount = inputNumber("Enter amount: ");
        String transferPrompt = String.format("Transfer %d to %d (%s)%nTo continue, please enter your PIN: ",
                amount, destinationAccountNumber, getFullName(destinationAccountNumber));

        String pin = inputText(transferPrompt);
        bank.transfer(sourceAccountNumber, destinationAccountNumber, amount, pin);
        mainMenu("Transfer successful");
    }

    private static void withdraw() {
        int accountNumber = inputNumber("Enter your account number: ");
        int amount = inputNumber("Enter amount to withdraw: ");
        String pin = inputText("Enter your PIN code: ");
        bank.withdraw(accountNumber, amount, pin);
        mainMenu("Withdraw Successful");
    }

    private static void deposit() {
        int accountNumber = inputNumber("Enter the account number: ");
        int amount = inputNumber("Enter amount to deposit: ");
        bank.deposit(accountNumber, amount);
        mainMenu("Deposit Successful");
    }

    private static void createAccount()  {
        String firstName = inputText("Enter your first name: ");
        String lastName = inputText("Enter your last name: ");
        String pin = inputText("Enter your PIN code: ");
        int accountNumber = bank.createAccount(firstName, lastName, pin);
        mainMenu("Account Created Successfully\n" + accountInfo(accountNumber));
    }

    private static String accountInfo(int accountNumber) {
        final String fullName = getFullName(accountNumber);
        return String.format("%s%nAccount number: %d%nAccount name: %s%n%s%n",
                "-".repeat(10), accountNumber, fullName, "-".repeat(10));
    }

    private static String getFullName(int accountNumber) {
        return bank.getAccountFirstName(accountNumber) + " " + bank.getAccountLastName(accountNumber);
    }

    private static void print(String text) {
        System.out.print(text);
    }

    private static int inputNumber(String prompt) {
        print(prompt);
        Scanner scanner = new Scanner(System.in);
//        later collect string and sterilise
        return scanner.nextInt();
    }
    //    later I will create an input helper function that accept regular expression
//    to perform sterilization
    private static String inputText(String prompt) {
        print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

//    try and catch inputs: create a sterilization package to sterilise
//    values like phone number, name, year, date,....
//    also try and catch bank call

}
