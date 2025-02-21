package main.applications;

import diary.services.Diary;

import static main.applications.DiaryMenu.diaryMenu;
import static main.applications.DiaryMenu.toggleDiaryLock;
import static main.applications.MainMenu.*;

public class DiarySettingsMenu {
    public static void diarySettingsMenu(String notification, Diary diary) {
        clearScreen();
        String diarySettingsMenuPrompt = """
                -----ONWARD DIARY SERVICE------
                Diary Settings:
                1 -> Change Diary username
                2 -> Change Diary password
                3 -> Go Back
                0 -> Exit
                
                """ + notification + "\n>>>";
        int choice = inputNumber(diarySettingsMenuPrompt);
        switch (choice) {
            case 1 -> changeDiaryUsername(diary);
            case 2 -> changeDiaryPassword(diary);
            case 3 -> diaryMenu(infoMessage("Welcome to your diary."), diary);
            case 0 -> exitDiary();
            default -> diarySettingsMenu(errorMessage("Invalid selection, Try again."), diary);
        }
        diaryMenu(successMessage("Your changes were successful"), diary);
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
                diary.changeUsername(newUsername, password);
                diarySettingsMenu(successMessage("Your username was changed successfully."), diary);
            } catch (IllegalArgumentException e) {
                diarySettingsMenu(errorMessage(e.getMessage()), diary);
            }
        }else {
            diarySettingsMenu(infoMessage("No changes were made."), diary);
        }
    }

    private static void changeDiaryPassword(Diary diary) {
        if (diary.isLocked()) {
            toggleDiaryLock(diary);
        }
        String confirmationPrompt = "Are you sure you want to change your password? (y/n)";
        boolean isConfirmed = getConfirmation(confirmationPrompt);

        if (isConfirmed) {
            String newPassword = input("Please enter your new password: ");
            String currentPassword = input("Please enter your password to authorise your changes: ");
            try {
                diary.changePassword(newPassword, currentPassword);
                diarySettingsMenu(successMessage("Your password was changed successfully."), diary);
            } catch (IllegalArgumentException e) {
                diarySettingsMenu(errorMessage(e.getMessage()), diary);
            }
        } else {
            diarySettingsMenu(infoMessage("No changes were made."), diary);
        }
    }

}
