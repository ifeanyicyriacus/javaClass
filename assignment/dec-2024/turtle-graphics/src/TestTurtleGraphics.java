import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestTurtleGraphics {
    @Test
    public void testThatTurtleGraphicExist() {
        new TurtleGraphics();
    }


}

class TestTurtle {
    @Test
    public void testThatTurtleWasCreated() {
        Turtle turtle = new Turtle(20, 20);
        assertEquals(0, turtle.getX());
        assertEquals(0, turtle.getY());
        assertEquals(Turtle.PenState.UP, turtle.getPenState());
        assertEquals(Turtle.Orientation.EAST, turtle.getOrientation());
    }

    @Test
    public void testThatTurtleWasMoved() {
        Turtle turtle = new Turtle(20, 20);
        turtle.move(4, 4);
        assertEquals(4, turtle.getX());
        assertEquals(4, turtle.getY());
        assertEquals(Turtle.Orientation.EAST, turtle.getOrientation());
    }

    @Test
    public void testThatTurtleWasTurned() {
        Turtle turtle = new Turtle(20, 20);
        assertEquals(Turtle.Orientation.EAST, turtle.getOrientation());
        turtle.turnRIGHT();
        assertEquals(Turtle.Orientation.SOUTH, turtle.getOrientation());
        turtle.turnLEFT();
        assertEquals(Turtle.Orientation.EAST, turtle.getOrientation());
        turtle.turnLEFT();
        assertEquals(Turtle.Orientation.NORTH, turtle.getOrientation());
        turtle.turnLEFT();
        assertEquals(Turtle.Orientation.WEST, turtle.getOrientation());
    }

}
