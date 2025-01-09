import java.util.Scanner;

public class DiaryApp {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String welcomeMessage = """
                Diary App
                (Non-AI powered journaling app)""";

        mainMenu();
    }

    public static void mainMenu() {
        String mainMenu = """
                MainMenu:
                1. Create New Diary
                2. Open My Diaries
                3. Exit
                """;

        boolean isJournaling = true;
        while (isJournaling) {
            System.out.print(mainMenu);
            int choice = input.nextInt();
            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 0:
                    isJournaling = false;
                    break;
                default:

            }


        }
    }

}
