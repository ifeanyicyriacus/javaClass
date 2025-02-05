package menues;

import static menues.OkoliBankATM.*;

public class AccountSettingsMenu {

    static void accountSettingsMenu(String prompt, int accountNumber) {
        clearScreen();
        String menuPrompt = BANK_NAME + """
                
                Main Menu/Update Profile:
                1: Change First Name
                2: Change Last Name
                3: Reset PIN
                4: |<- Go back to Main Menu
                0: Exit
                """ + prompt + "\n>>>";

        int choice = inputInteger(menuPrompt);
        switch (choice) {
            case 1 -> updateFirstName(accountNumber);
            case 2 -> updateLastName(accountNumber);
            case 3 -> resetPin(accountNumber);
            case 4 -> mainMenu(successMessage("Welcome again!!!"));
            case 0 -> exitBank();
            default -> accountSettingsMenu(errorMessage("Invalid selection: Try again"), accountNumber);
        }
    }

    private static void updateFirstName(int accountNumber) {
        String newFirstName = inputText("Enter new first name: ");
        String pin = inputText("Enter new pin: ");
        try {
            bank.updateFirstName(accountNumber, newFirstName, pin);
            accountSettingsMenu(successMessage("First Name set to: " + newFirstName), accountNumber);
        } catch (IllegalArgumentException e) {
            accountSettingsMenu(errorMessage("Update failed: " + e.getMessage()), accountNumber);
        }
    }

    private static void updateLastName(int accountNumber) {
        String newLastName = inputText("Enter new last name: ");
        String pin = inputText("Enter new pin: ");
        try{
            bank.updateLastName(accountNumber, newLastName, pin);
            accountSettingsMenu(successMessage("Last Name set to: " + newLastName), accountNumber);
        } catch (IllegalArgumentException e) {
            accountSettingsMenu(errorMessage("Update failed: " + e.getMessage()), accountNumber);
        }
    }

    private static void resetPin(int accountNumber) {
        String currentPin = inputText("Enter your PIN: ");
        String newPin = inputText("Enter your new PIN: ");
        try{
            bank.resetPIN(accountNumber, currentPin, newPin);
            accountSettingsMenu(successMessage("Reset PIN completed!"), accountNumber);
        } catch (IllegalArgumentException e) {
            accountSettingsMenu(errorMessage("Reset PIN failed: " + e.getMessage()), accountNumber);
        }
    }
}
