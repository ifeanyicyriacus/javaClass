public class Turtle {
    public static final String TOKEN = "1";

    public enum PenState {
        UP, DOWN
    }
    public enum Orientation {
        NORTH, EAST, SOUTH, WEST
    }

    private final int noOfRows;
    private final int noOfColumns;
    private int         x;
    private int         y;
    private PenState    penState;
    private Orientation orientation;

    public Turtle(int noOfRows, int noOfColumns) {
        this.x = 0;
        this.y = 0;
        this.noOfRows = noOfRows;
        this.noOfColumns = noOfColumns;
        this.penState = PenState.UP;
        this.orientation = Orientation.EAST;
    }

    public int getX() {
        return x;
    }

    private void setX(int x) {
        if (x >= 0 && x < noOfRows){
            this.x = x;
        } else {
            System.out.println("\033[A\033[K\033[31mERROR: you have exceeded the horizontal boundary\033[0m");
        }
    }

    public int getY() {
        return y;
    }

    private void setY(int y) {
        if (y >= 0 && y < noOfColumns){
            this.y = y;
        } else {
            System.out.println("\033[A\033[K\033[31mERROR: you have exceeded the vertical boundary\033[0m");
        }
    }

    public void move(int x, int y) {
        setX(x);
        setY(y);
    }

    public PenState getPenState() {
        return penState;
    }

    public void penUP() {
        this.penState = PenState.UP;
    }

    public void penDOWN() {
        this.penState = PenState.DOWN;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    private void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void turnRIGHT() {
        int index = getOrientation().ordinal();
        index = (index + 1) % Orientation.values().length;
        setOrientation(Orientation.values()[index]);
    }
    public void turnLEFT() {
        int index = getOrientation().ordinal();
        int orientationLength = Orientation.values().length;
        index = (index - 1 + orientationLength) % orientationLength;
        setOrientation(Orientation.values()[index]);
    }

    public void moveForwardOneStep() {
        int currentPosX = getX();
        int currentPosY = getY();

        switch (getOrientation()) {
            case NORTH -> move(currentPosX, --currentPosY);
            case SOUTH -> move(currentPosX, ++currentPosY);
            case EAST -> move(++currentPosX, currentPosY);
            case WEST -> move(--currentPosX, currentPosY);
            default -> throw new IllegalStateException("Unexpected value: " + orientation);
        }
    }
}