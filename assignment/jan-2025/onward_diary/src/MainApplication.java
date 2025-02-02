import diary_services.Diaries;
import diary_services.Diary;
import diary_services.Entry;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApplication {
    private final static Diaries diaries = new Diaries();

    public static void main(String[] args) {
        mainMenu(successMessage("Welcome!!!"));
    }

    private static void mainMenu(String notification) {
        clearScreen();
        String mainMenuPrompt = """
                -----ONWARD DIARY SERVICE------
                Main Menu:
                1 -> Add Diary
                2 -> Open Diary
                3 -> Delete Diary
                0 -> Exit
                
                """ + notification + "\n>>>";

        int choice = inputNumber(mainMenuPrompt);
        switch (choice) {
            case 1 -> addDiary();
            case 2 -> openDiary();
            case 3 -> deleteDiary();
            case 0 -> exitDiary();
            default -> mainMenu(errorMessage("Invalid selection, Try again."));
        }
        mainMenu(notification);
    }

    private static void exitDiary() {
        System.exit(0);
    }

    private static void deleteDiary() {
        String username = input("Please enter your username: ");
        String password = input("Please enter your password: ");

        int noOfEntries = 0;
        try {
            noOfEntries = diaries.findByUsername(username).getNoOfEntries();
        } catch (IllegalArgumentException e) {
            print(e.getMessage());
            mainMenu(errorMessage("Failed to delete: Invalid username, try again."));
        }
        boolean isConfirmed = true;
        if (noOfEntries > 0) {
            String confirmationPrompt = String.format("Your diary has %d entries. " +
                    "Are you sure you want to delete this diary? (y/n)", noOfEntries);
            isConfirmed = getConfirmation(confirmationPrompt);
        }

        if (isConfirmed) {
            try {
                diaries.delete(username, password);
            } catch (IllegalArgumentException e) {
                print(e.getMessage());
            }
            mainMenu(successMessage("Successfully deleted the diary."));
        } else {
            mainMenu(infoMessage("Deletion attempt was avoided - close call!"));
        }
    }

    private static boolean getConfirmation(String confirmationPrompt) {
        clearScreen();
        String choice = input(infoMessage(confirmationPrompt));
        return switch (choice.toLowerCase()) {
            case "y" -> true;
            case "n" -> false;
            default -> {
                print("Invalid selection, only 'Y' and 'N' are valid, try again.");
                yield getConfirmation(confirmationPrompt);
            }
        };
    }

    private static void openDiary() {
        String username = input("Please enter your username: ");
        Diary diary = null;
        try {
            diary = diaries.findByUsername(username);
        } catch (IllegalArgumentException e) {
            mainMenu(e.getMessage());
        }
        diaryMenu(successMessage(username + ", Welcome to your diary."), diary);
    }

    private static void diaryMenu(String notification, Diary diary) {
        clearScreen();
        String diaryMenuPrompt = """
                -----ONWARD DIARY SERVICE------
                Diary Menu:
                1 -> Add new Entry
                2 -> View your Entries (""" + diary.getNoOfEntries() + """
                )
                3 -> Update Entry
                4 -> Find Entry
                5 -> Delete Entry
                """ +
                String.format("6 -> %s diary", (diary.isLocked()) ? "Unlock" : "Lock")
                + """
                
                7 -> Change Diary Settings
                8 -> Log Out
                0 -> Exit
                
                """ + notification + "\n>>>";

        int choice = inputNumber(diaryMenuPrompt);
        switch (choice) {
            case 1 -> addEntry(diary);
            case 2 -> readEntries(diary);
            case 3 -> updateEntry(diary);
            case 4 -> findEntry(diary);
            case 5 -> deleteEntry(diary);
            case 6 -> toggleDiaryLock(diary);
            case 7 -> diarySettingsMenu(infoMessage("Remember to take note of your new changes"), diary);
            case 8 -> mainMenu(successMessage("Log Out!!!"));
            case 0 -> exitDiary();
            default -> diaryMenu(errorMessage("Invalid selection, Try again."), diary);
        }
        diaryMenu(notification, diary);
    }

    private static void diarySettingsMenu(String notification, Diary diary) {
        clearScreen();
        String diarySettingsMenuPrompt = """
                -----ONWARD DIARY SERVICE------
                Diary Settings:
                1 -> Change Diary username
                2 -> Change Diary password
                8 -> Go Back
                0 -> Exit
                
                """ + notification + "\n>>>";
        int choice = inputNumber(diarySettingsMenuPrompt);
        switch (choice) {
            case 1 -> changeDiaryUsername(diary);
            case 2 -> changeDiaryPassword(diary);
            case 8 -> diaryMenu(infoMessage("Welcome to your diary."), diary);
            case 0 -> exitDiary();
            default -> diarySettingsMenu(errorMessage("Invalid selection, Try again."), diary);
        }
        diaryMenu(successMessage("Your changes were successful"), diary);
    }

    private static void changeDiaryPassword(Diary diary) {
        if (diary.isLocked()) { toggleDiaryLock(diary); }
        String confirmationPrompt = "Are you sure you want to change your password? (y/n)";
        boolean isConfirmed = getConfirmation(confirmationPrompt);
        if (isConfirmed) {
            String currentPassword = input("Please enter your current password: ");
            String newPassword = input("Please enter your new password: ");
            try {
                diary.changePassword(currentPassword, newPassword);
            } catch (IllegalArgumentException e) {
                diarySettingsMenu(errorMessage(e.getMessage()), diary);
            }
        } else {
            diarySettingsMenu(infoMessage("No changes were made."), diary);
        }
    }

    private static void changeDiaryUsername(Diary diary) {
        if (diary.isLocked()) {
            toggleDiaryLock(diary);
        }
        String oldUsername = diary.getUsername();
        String confirmationPrompt = String.format("Your old username is (%s)%n " +
                        "Are you sure you want to change your username? (y/n)", oldUsername);
        boolean isConfirmed = getConfirmation(confirmationPrompt);
        if (isConfirmed) {
            String newUsername = input("Please enter your new username: ");
            String password = input("Please enter your password to authorise your changes: ");
            try{
                diary.changePassword(newUsername, password);
            } catch (IllegalArgumentException e) {
                diarySettingsMenu(errorMessage(e.getMessage()), diary);
            }
            diarySettingsMenu(successMessage("Your username was changed successfully."), diary);
        }else {
            diarySettingsMenu(infoMessage("No changes were made."), diary);
        }
    }

    private static void deleteEntry(Diary diary) {
        clearScreen();
        int entryId = inputNumber("Please enter an entry ID: ");
        Entry entry = null;
        try {
            entry = diary.findEntryById(entryId);
        } catch (IllegalArgumentException e) {
            diaryMenu(errorMessage(e.getMessage()), diary);
        }
        String confirmationPrompt = String.format("%s%n" +
                "Are you sure you want to delete this entry? (y/n)", entry);
        boolean isConfirmed = getConfirmation(confirmationPrompt);
        if (isConfirmed){
            diary.delete(entryId);
            diaryMenu(successMessage("Successfully deleted the entry"), diary);
        } else {
            diaryMenu(infoMessage("Deletion was avoided - close call!"), diary);
        }
    }

    private static void findEntry(Diary diary) {
        clearScreen();
        int entryId = inputNumber("Please enter an entry ID: ");
        try {
            print(diary.findEntryById(entryId).toString());
        } catch (IllegalArgumentException e) {
            print(errorMessage(e.getMessage()));
        }
    }

    private static void updateEntry(Diary diary) {
        clearScreen();
        int entryId = inputNumber("Please enter an entry ID: ");
        Entry entry = null;
        try {
            entry = diary.findEntryById(entryId);
        } catch (IllegalArgumentException e) {
            diaryMenu(errorMessage(e.getMessage()), diary);
        }
        clearScreen();
        String confirmationPrompt = String.format("%s%n" +
                "Are you sure you want to update this entry? (y/n)", entry);
        boolean isConfirmed = getConfirmation(confirmationPrompt);
        if (isConfirmed) {
            String newTitle = input("Please enter a new title (or enter to skip): ");
            String newBody = input("Please enter a body (or enter to skip): ");
            newTitle = (newTitle.isEmpty()) ? entry.getTitle() : newTitle;
            newBody = (newBody.isEmpty()) ? entry.getBody() : newBody;
            diary.updateEntry(entryId, newTitle, newBody);
            diaryMenu(successMessage("Update was successful"), diary);
        } else{
            diaryMenu(infoMessage("No changes were made."), diary);
        }
    }

    private static void readEntries(Diary diary) {
        print(diary.toString());
    }

    private static void toggleDiaryLock(Diary diary) {
        if (!diary.isLocked()) {
            diary.lock();
            print(infoMessage("Mischief managed\uD83E\uDE84"));
        } else {
            String password = input("Please enter your password to unlock: ");
            try {
                diary.unlock(password);
            } catch (IllegalArgumentException e) {
                diaryMenu(errorMessage(e.getMessage()), diary);
            }
        }
    }

    private static void addEntry(Diary diary) {
        if (diary.isLocked()) {
            print(infoMessage("Diary is locked!, "));
            toggleDiaryLock(diary);
        }
        print("Adding new entry");
        String title = input("Please enter the title: ");
        String body = input("Please enter the body: ");
        try {
            diary.createEntry(title, body);
        } catch (IllegalArgumentException e) {
            diaryMenu(errorMessage(e.getMessage()), diary);
        }
        diaryMenu(successMessage("(" +title + ") added successfully."), diary);
    }

    private static void addDiary() {
        String username = input("Enter your username: ");
        String password = input("Enter your password: ");
        try {
            diaries.add(username, password);
        } catch (IllegalArgumentException e) {
            print(e.getMessage());
            addDiary();
        }
        mainMenu(successMessage("New Diary Added Successfully! for user: " + username));
    }

    private static String input(String prompt) {
        print(prompt);
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextLine();
        } catch (InputMismatchException inputMismatchException) {
            clearScreen();
            print(errorMessage(inputMismatchException.getMessage()));
            return input(prompt);
        }
    }

    private static int inputNumber(String prompt) {
        print(prompt);
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            clearScreen();
            print(errorMessage(inputMismatchException.getMessage()));//custom: Only Numbers 0 - 9 are supported
            return inputNumber(prompt);
        }
    }

    private static void print(String prompt) {
        System.out.println(prompt);
    }

    private static void clearScreen() {
        print("\033[H\033[2J");
    }
    private static String errorMessage(String prompt) {
        return "\033[31m" + prompt + "\033[0m";
    }
    private static String successMessage(String prompt) {
        return "\033[32m" + prompt + "\033[0m";
    }
    private static String infoMessage(String prompt) {
        return "\033[33m" + prompt + "\033[0m";
    }
}
