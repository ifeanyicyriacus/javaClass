import java.util.Scanner;

public class Main {
    private static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Dynamite Tic-Tac-Toe Game");
        selectGameMode();
        System.out.println("GAME OVER");
    }

    private static boolean selectGameMode() {
        String gameModeMenu = """
                Choose Game Mode:
                1. Single Player - CPU Clash:
                   Defend the human dignity!
                2. Two Player - Tic-Tac-Toe Takedown:
                   Challenge your fellow mortal!
                0. Exit ->|
                    Quit the game (but why would you want to?)
                """;

        boolean gameOn = true;
        while (gameOn) {
            System.out.println(gameModeMenu);
            int gameModeChoice = INPUT.nextInt();
            gameOn = switch (gameModeChoice) {
                case 1, 2 -> selectDifficultyLevel(gameModeChoice);
                case 0 -> false;
                default -> {
                    System.out.println("Invalid Choice, Try Again.");
                    yield true;
                }
            };
        }
        return false;
    }

    private static boolean selectDifficultyLevel(int noOfPlayers) {
        String difficultLevelMenu = """
                Select Difficulty Level:
                1. Easy (3 X 3)
                2. Hard (4 X 4)
                3. Dangerous (4 X 4 X 4)
                0. |<- go back.
                """;
        boolean gameOn = true;
        while (gameOn) {
            System.out.println(difficultLevelMenu);
            int difficultLevelChoice = INPUT.nextInt();
            gameOn = switch (difficultLevelChoice) {
                case 1, 2, 3 -> {
                    startGame(noOfPlayers, difficultLevelChoice);
                    System.out.println("\nPlay Again");
                    yield true;
                }
                case 0 -> selectGameMode();
                default -> {
                    System.out.println("Invalid Choice, Try Again.");
                    yield true;
                }
            };
        }
        return false;
    }

    private static void startGame(int noOfPlayers, int difficultLevel) {
        TicTacToe ticTacToe = new TicTacToe(noOfPlayers, difficultLevel);
        ticTacToe.startGame();
    }
}