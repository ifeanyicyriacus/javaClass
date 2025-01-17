import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TurtleGraphics turtleGraphics = new TurtleGraphics();

        final String instructionSet = """
                Command |  Meaning
                - - - - + - - - - -
                1       |  Pen up
                2       |  Pen down
                3       |  Turn right
                4       |  Turn left
                5,N     |  Move forward N spaces (replace N for a number)
                6       |  Display the 20-by-20 array
                9       |  End of data (sentinel)
                <Separate commands by new line>
                """;

        System.out.println(instructionSet);

        boolean sentinel = true;
        while (sentinel) {
            String command = input.nextLine();
            switch (command) {
                case "1", "2", "3", "4" -> {
                    colourCommandTextGreen(command);
                    turtleGraphics.parser(command);
                }
                case "6" -> {
                    colourCommandTextGreen(command);
                    System.out.println(turtleGraphics.displayGraphics());
                }
                case "9" -> {
                    colourCommandTextGreen(command);
                    sentinel = false;
                }
                default -> {
                    String[] temp = command.split(",");
                    if ((temp.length == 2) && temp[0].equals("5") && (Integer.parseInt(temp[1]) >= 1)) {
                        colourCommandTextGreen(command);
                        turtleGraphics.parser(command);
                    } else {
                        clearPreviousLine();
                    }
                }
            }
        }
    }

    private static void clearPreviousLine() {
        System.out.print("\033[A\033[K");
    }

    private static void colourCommandTextGreen(String command) {
        clearPreviousLine();
        System.out.println("\033[32m" + command + "\033[0m");
    }
}
