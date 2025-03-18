package main.applications;

import diary.services.Diaries;
import diary.services.Diary;

import java.util.InputMismatchException;
import java.util.Scanner;

import static main.applications.DiaryMenu.*;

public class MainMenu {
    private final static Diaries diaries = new Diaries();

    public static void main(String[] args) {
        try {
            mainMenu(successMessage("Welcome!!!"));
        } catch (RuntimeException e) {
            mainMenu(errorMessage(e.getMessage()));
        }
    }

    static void mainMenu(String notification) {
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

    private static Diary getDiary(String username) {
        Diary diary = null;
        try {
            diary = diaries.findByUsername(username);
        } catch (IllegalArgumentException e) {
            mainMenu(errorMessage(e.getMessage()));
        }
        return diary;
    }

    private static void openDiary() {
        String username = input("Please enter your username: ");
        final Diary diary = getDiary(username);
        diaryMenu(successMessage(username + ", Welcome to your diary."), diary);
    }

    private static void deleteDiary() {
        String username = input("Please enter your username: ");
        String password = input("Please enter your password: ");
        int noOfEntries = getDiary(username).getNoOfEntries();

        String confirmationPrompt = String.format("Your diary has %d entries. " +
                "Are you sure you want to delete this diary? (y/n)", noOfEntries);
        boolean isConfirmed = getConfirmation(confirmationPrompt);

        if (isConfirmed) {
            try {
                diaries.delete(username, password);
                mainMenu(successMessage("Successfully deleted the diary."));
            } catch (IllegalArgumentException e) {
                mainMenu(errorMessage(e.getMessage()));
            }
        } else {
            mainMenu(infoMessage("Deletion attempt was avoided - close call!"));
        }
    }

    static void exitDiary() {
        System.exit(0);
    }

    static boolean getConfirmation(String confirmationPrompt) {
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

    static String input(String prompt) {
        print(prompt);
        Scanner scanner = new Scanner(System.in);
        try {
            String value = scanner.nextLine();
            if (value.isEmpty()) {
                throw new InputMismatchException("Field cannot be blank");
            } else {
                return value;
            }
        } catch (InputMismatchException inputMismatchException) {
            clearScreen();
            print(errorMessage(inputMismatchException.getMessage()));
            return input(prompt);
        }
    }

    static int inputNumber(String prompt) {
        print(prompt);
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            clearScreen();
            print(errorMessage("Only numbers are allowed. Try again."));
            return inputNumber(prompt);
        }
    }

    static void print(String prompt) {
        System.out.println(prompt);
    }

    static void clearScreen() {
        print("\033[H\033[2J");
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
