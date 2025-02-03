package main_application;

import diary_services.Diary;
import diary_services.Entry;

import static main_application.DiarySettingsMenu.diarySettingsMenu;
import static main_application.MainMenu.*;

public class DiaryMenu {
    private static int incorrectInput = 3;
    public static void diaryMenu(String notification, Diary diary) {
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
            case 8 -> logOut(diary);
            case 0 -> exitDiary();
            default -> {
                if (incorrectInput == 0) {
                    incorrectInput = 3;
                    exitDiary();
                }
                diaryMenu(errorMessage(String.format("Invalid selection, Try again.(%d tries left)", incorrectInput--)), diary);
            }
        }
    }

    private static void addEntry(Diary diary) {
        clearScreen();
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
        diaryMenu(successMessage("(" + title + ") added successfully."), diary);
    }

    private static void readEntries(Diary diary) {
        diaryMenu(diary.toString(), diary);
    }

    private static Entry getEntry(Diary diary) {
        clearScreen();
        int entryId = inputNumber("Please enter an entry ID: ");
        try {
            return diary.findEntryById(entryId);
        } catch (IllegalArgumentException e) {
            diaryMenu(errorMessage(e.getMessage()), diary);
        }
        clearScreen();
        return null;
    }

    private static void updateEntry(Diary diary) {
        Entry entry = getEntry(diary);
        final boolean isConfirmed = getConfirmation("Are you sure you want to update this entry? (y/n)", entry);
        if (isConfirmed && entry != null) {
            String newTitle = input("Please enter a new title (or enter to skip): ");
            String newBody = input("Please enter a body (or enter to skip): ");
            newTitle = (newTitle.isEmpty()) ? entry.getTitle() : newTitle;
            newBody = (newBody.isEmpty()) ? entry.getBody() : newBody;
            diary.updateEntry(entry.getID(), newTitle, newBody);
            diaryMenu(successMessage("Update was successful"), diary);
        } else {
            diaryMenu(infoMessage("No changes were made."), diary);
        }
    }

    private static void findEntry(Diary diary) {
        Entry entry = getEntry(diary);
        if (entry != null) {
            diaryMenu(entry.toString(), diary);
        }
    }

    private static void deleteEntry(Diary diary) {
        Entry entry = getEntry(diary);
        final boolean isConfirmed = getConfirmation("Are you sure you want to delete this entry? (y/n)", entry);
        if (isConfirmed && entry != null) {
            diary.delete(entry.getID());
            diaryMenu(successMessage("Successfully deleted the entry"), diary);
        } else {
            diaryMenu(infoMessage("Deletion was avoided - close call!"), diary);
        }
    }

    private static boolean getConfirmation(String prompt, Entry entry) {
        String confirmationPrompt = String.format("%s%n%s" , entry, prompt);
        return MainMenu.getConfirmation(confirmationPrompt);
    }

    static void toggleDiaryLock(Diary diary) {
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

    private static void logOut(Diary diary) {
        diary.lock();
        mainMenu(successMessage("Log Out!!!"));
    }
}
