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
        for (int i = 1; i <= noOfSpaces; i++) {
            turtle.moveForwardOneStep();
            drawOrPass();
        }
    }

    private void drawOrPass() {
        if (turtle.getPenState().equals(Turtle.PenState.DOWN)) {
            floor[turtle.getY()][turtle.getX()] = Turtle.TOKEN;
        }
    }
}
