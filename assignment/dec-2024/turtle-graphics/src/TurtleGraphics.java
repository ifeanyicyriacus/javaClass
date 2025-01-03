import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TurtleGraphics {
    public static void main(String[] args) {

        final String[][] pixels = new String[20][20];
        final Turtle turtle = new Turtle();
        ArrayList<String> commands = new ArrayList<String>();

        for (String[] row: pixels){
            Arrays.fill(row,"0");
        }

        final String instructionSet = """
                Command |  Meaning
                - - - - + - - - - -
                1       |  Pen up
                2       |  Pen down
                3       |  Turn right
                4       |  Turn left
                5,N     |  Move forward n spaces (replace n for a number)
                6       |  Display the 20-by-20 array
                9       |  End of data (sentinel)
                <Separate commands by new line>
                """;

        System.out.println(instructionSet);
        Scanner input = new Scanner(System.in);

        boolean sentinel = true;
        while (sentinel) {
            String command = input.nextLine();
            switch (command) {
                case "1", "2", "3", "4" -> {
                    colourCommandTextGreen(command);
                    commands.add(command);
                }
                case "6" -> {
                    colourCommandTextGreen(command);
                    System.out.println(displayGraphics(pixels));
                }
                case "9" -> {
                    colourCommandTextGreen(command);
                    sentinel = false;
                }
                default -> {
                    String[] temp = command.split(",");
                    if ((temp.length == 2) && temp[0].equals("5") && (Integer.parseInt(temp[1]) >= 1)) {
                        colourCommandTextGreen(command);
                        commands.add(command);
                    }
                    System.out.print("\033[A\033[K");
                }
            }


        }

    }

    private static void colourCommandTextGreen(String command) {
        System.out.print("\033[A\033[K");
        System.out.println("\033[32m" + command + "\033[0m");
    }

    private static String displayGraphics(String[][] pixels) {
        StringBuilder output = new StringBuilder();
        for (String[] row: pixels){
            output.append(
                    Arrays.toString(row).replace("1", "*").replace("0", "z"));
            output.append("\n");
        }

        return output.toString();
    }

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        for (String[] row: getPixels()){
//            for (String pixel: row){
//                builder.append(pixel.equals("1") ? "*": " ");
//            }
//            builder.append("\n");
//        }
//        return builder.toString();
//    }
}
