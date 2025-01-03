public class Turtle {
    public static final String TOKEN = "🐢";

    private int         x;
    private int         y;
    private PenState    penState;
    private Orientation orientation;


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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

    public void setOrientation(Orientation orientation) {
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

    public enum PenState {
        UP, DOWN
    }

    ;

    public enum Orientation {
        NORTH, EAST, SOUTH, WEST
    }

    public Turtle() {
        this.x = 0;
        this.y = 0;
        this.penState = PenState.UP;
        this.orientation = Orientation.EAST;
    }


}
