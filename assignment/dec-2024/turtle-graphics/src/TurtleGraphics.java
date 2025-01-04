import java.util.Arrays;
import java.util.Scanner;

public class TurtleGraphics {
    public static void main(String[] args) {

        final String[][] floor = new String[20][20];
        final Turtle turtle = new Turtle();

        for (String[] row : floor) {
            Arrays.fill(row, "0");
        }

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
        Scanner input = new Scanner(System.in);

        boolean sentinel = true;
        while (sentinel) {
            String command = input.nextLine();
            switch (command) {
                case "1", "2", "3", "4" -> {
                    colourCommandTextGreen(command);
                    parser(command, turtle, floor);
                }
                case "6" -> {
                    colourCommandTextGreen(command);
                    System.out.println(displayGraphics(floor));
                }
                case "9" -> {
                    colourCommandTextGreen(command);
                    sentinel = false;
                }
                default -> {
                    String[] temp = command.split(",");
                    if ((temp.length == 2) && temp[0].equals("5") && (Integer.parseInt(temp[1]) >= 1)) {
                        colourCommandTextGreen(command);
                        parser(command, turtle, floor);
                    } else {
                        System.out.print("\033[A\033[K");
                    }
                }
            }
        }
    }

    private static void colourCommandTextGreen(String command) {
        System.out.print("\033[A\033[K");
        System.out.println("\033[32m" + command + "\033[0m");
    }

    private static String displayGraphics(String[][] floor) {
        StringBuilder output = new StringBuilder();
        for (String[] row : floor) {
            output.append(
                    Arrays.toString(row).replace("1", "🐢").replace("0", "  "));
            output.append("\n");
        }
        return output.toString();
    }

    private static void parser(String command, Turtle turtle, String[][] floor) {
        switch (command) {
            case "1" -> turtle.penUP();
            case "2" -> turtle.penDOWN();
            case "3" -> turtle.turnRIGHT();
            case "4" -> turtle.turnLEFT();
            default -> {
                int noOfSpaces = Integer.parseInt(command.split(",")[1]);
                moveForward(noOfSpaces, turtle, floor);
            }
        }
    }

    private static void moveForward(int noOfSpaces, Turtle turtle, String[][] floor) {
        Turtle.PenState penState = turtle.getPenState();
        Turtle.Orientation orientation = turtle.getOrientation();
        int currentPosX = turtle.getX();
        int currentPosY = turtle.getY();
        String token = Turtle.TOKEN;

        for (int i = 1; i <= noOfSpaces; i++) {
            switch (orientation) {
                case NORTH -> move(turtle, currentPosX, --currentPosY);
                case SOUTH -> move(turtle, currentPosX, ++currentPosY);
                case EAST -> move(turtle, ++currentPosX, currentPosY);
                case WEST -> move(turtle, --currentPosX, currentPosY);
                default -> throw new IllegalStateException("Unexpected value: " + orientation);
            }
            if (penState.equals(Turtle.PenState.DOWN)) {
                floor[currentPosY][currentPosX] = token;
            }
        }
    }

    private static void move(Turtle turtle, int newPosX, int newPosY) {
        turtle.setX(newPosX);
        turtle.setY(newPosY);
    }

}
