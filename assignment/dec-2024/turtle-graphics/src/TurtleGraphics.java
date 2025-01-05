import java.util.Arrays;

public class TurtleGraphics {
    final String[][] floor;
    final Turtle     turtle;
    
    public TurtleGraphics() {
        this.floor = new String[20][20];
        this.turtle = new Turtle();

        for (String[] row : this.floor) {
            Arrays.fill(row, "0");
        }
    }
    
    public String displayGraphics() {
        StringBuilder output = new StringBuilder();
        for (String[] row : floor) {
            output.append(
                    Arrays.toString(row).replace("1", "🐢").replace("0", "  "));
            output.append("\n");
        }
        return output.toString();
    }

    public void parser(String command) {
        switch (command) {
            case "1" -> turtle.penUP();
            case "2" -> turtle.penDOWN();
            case "3" -> turtle.turnRIGHT();
            case "4" -> turtle.turnLEFT();
            default -> {
                int noOfSpaces = Integer.parseInt(command.split(",")[1]);
                moveForward(noOfSpaces);
            }
        }
    }

    private void moveForward(int noOfSpaces) {
        Turtle.PenState penState = turtle.getPenState();
        Turtle.Orientation orientation = turtle.getOrientation();
        int currentPosX = turtle.getX();
        int currentPosY = turtle.getY();
        String token = Turtle.TOKEN;

        for (int i = 1; i <= noOfSpaces; i++) {
            switch (orientation) {
                case NORTH -> turtle.move(currentPosX, --currentPosY);
                case SOUTH -> turtle.move(currentPosX, ++currentPosY);
                case EAST -> turtle.move(++currentPosX, currentPosY);
                case WEST -> turtle.move(--currentPosX, currentPosY);
                default -> throw new IllegalStateException("Unexpected value: " + orientation);
            }
            if (penState.equals(Turtle.PenState.DOWN)) {
                floor[currentPosY][currentPosX] = token;
            }
        }
    }
}
