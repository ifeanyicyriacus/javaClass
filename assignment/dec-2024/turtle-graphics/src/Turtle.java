public class Turtle {
    public static final String TOKEN = "1";

    public enum PenState {
        UP, DOWN
    }
    public enum Orientation {
        NORTH, EAST, SOUTH, WEST
    }

    private int         x;
    private int         y;
    private PenState    penState;
    private Orientation orientation;

    public Turtle() {
        this.x = 0;
        this.y = 0;
        this.penState = PenState.UP;
        this.orientation = Orientation.EAST;
    }

    public int getX() {
        return x;
    }

    private void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    private void setY(int y) {
        this.y = y;
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