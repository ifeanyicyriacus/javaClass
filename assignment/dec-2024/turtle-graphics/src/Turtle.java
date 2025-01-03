public class Turtle {
    private int x;
    private int y;
    private enum Direction {LEFT, RIGHT, NONE};
    private Direction direction;
    private enum PenState {UP, DOWN};
    private PenState penState;


    public Turtle() {
        this.x = 0;
        this.y = 0;
        this.penState = PenState.UP;
    }



}
