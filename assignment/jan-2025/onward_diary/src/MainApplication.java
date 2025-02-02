import diary_services.Diaries;
import diary_services.Diary;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApplication {
    private final static Diaries diaries = new Diaries();

    public static void main(String[] args) {
        mainMenu("Welcome!!!");


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
            default -> mainMenu("Invalid selection, Try again.");
        }
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
            mainMenu("Failed to delete: Invalid username, try again.");
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
            mainMenu("Successfully deleted the diary.");
        }
    }

    private static boolean getConfirmation(String confirmationPrompt) {
        print(confirmationPrompt);
        return switch (confirmationPrompt.toLowerCase()) {
            case "y" -> true;
            case "n" -> false;
            default -> getConfirmation(confirmationPrompt);
        };
    }

    private static void openDiary() {
        String username = input("Please enter your username: ");
        Diary diary;
        try {
            diary = diaries.findByUsername(username);
        } catch (IllegalArgumentException e) {
            mainMenu(e.getMessage());
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
        mainMenu("New Diary Added Successfully! for user: " + username);
    }

    private static String input(String prompt) {
        print(prompt);
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextLine();
        } catch (InputMismatchException inputMismatchException) {
            return input(prompt);
        }
    }

    private static int inputNumber(String prompt) {
        print(prompt);
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            return inputNumber(prompt);
        }
    }

    private static void clearScreen() {
        print("\033[H\033[2J");
    }

    private static void print(String prompt) {
        System.out.println(prompt);
    }


}
