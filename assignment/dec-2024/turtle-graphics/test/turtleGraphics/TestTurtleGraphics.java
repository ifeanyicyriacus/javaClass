import org.junit.jupiter.api.Test;
import turtleGraphics.Turtle;
import turtleGraphics.TurtleGraphics;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestTurtleGraphics {
    @Test
    public void testThatTurtleGraphic_wasCreated() {
        TurtleGraphics turtleGraphics = new TurtleGraphics();
        int length = turtleGraphics.getFloor().length;
        int width = turtleGraphics.getFloor()[0].length;
        assertEquals(20, length);
        assertEquals(20, width);
        for (String[] row : turtleGraphics.getFloor()) {
            for (String cells : row){
                assertEquals("0", cells);
            }
        }
    }
//    test that turtle is on one of the board's cell
//    test that turtle when moved is still on a cell
//    test that when turtle is down token are dropped on the board
//    test that the turtle don't exceed the bound of the cell

}

class TestTurtle {
    @Test
    public void testTurtle_Exist() {
       new Turtle(20, 20);
    }

    @Test
    public void testTurtle_FieldsHaveBeenInitializedToCorrectValue() {
        Turtle turtle = new Turtle(20, 20);
        assertEquals(0, turtle.getX());
        assertEquals(0, turtle.getY());
        assertEquals(Turtle.PenState.UP, turtle.getPenState());
        assertEquals(Turtle.Orientation.EAST, turtle.getOrientation());
    }

    @Test
    public void testTurtle_CanTurnRight() {
        Turtle turtle = new Turtle(20, 20);
        assertEquals(Turtle.Orientation.EAST, turtle.getOrientation());
        turtle.turnRIGHT();
        assertEquals(Turtle.Orientation.SOUTH, turtle.getOrientation());
        turtle.turnRIGHT();
        assertEquals(Turtle.Orientation.WEST, turtle.getOrientation());
        turtle.turnRIGHT();
        assertEquals(Turtle.Orientation.NORTH, turtle.getOrientation());
    }

    @Test
    public void testTurtle_CanTurnLeft() {
        Turtle turtle = new Turtle(20, 20);
        assertEquals(Turtle.Orientation.EAST, turtle.getOrientation());
        turtle.turnLEFT();
        assertEquals(Turtle.Orientation.NORTH, turtle.getOrientation());
        turtle.turnLEFT();
        assertEquals(Turtle.Orientation.WEST, turtle.getOrientation());
        turtle.turnLEFT();
        assertEquals(Turtle.Orientation.SOUTH, turtle.getOrientation());
    }

    @Test
    public void testTurtle_CanPenDown() {
        Turtle turtle = new Turtle(20, 20);
        assertEquals(Turtle.PenState.UP, turtle.getPenState());
        turtle.penDOWN();
        assertEquals(Turtle.PenState.DOWN, turtle.getPenState());
    }

    @Test
    public void testTurtle_CanPenUp() {
        Turtle turtle = new Turtle(20, 20);
        turtle.penDOWN();
        assertEquals(Turtle.PenState.DOWN, turtle.getPenState());
        turtle.penUP();
        assertEquals(Turtle.PenState.UP, turtle.getPenState());
    }

    @Test
    public void testTurtle_CanMoveForwardOnRow() {
        Turtle turtle = new Turtle(20, 20);
        turtle.moveForwardOneStep();
        assertEquals(1, turtle.getX());
        assertEquals(0, turtle.getY());
        turtle.moveForwardOneStep();
        assertEquals(2, turtle.getX());
        assertEquals(0, turtle.getY());
        assertEquals(Turtle.Orientation.EAST, turtle.getOrientation());
    }

    @Test
    public void testTurtle_CanMoveForwardOnColumn() {
        Turtle turtle = new Turtle(20, 20);
        turtle.turnRIGHT();
        turtle.moveForwardOneStep();
        assertEquals(0, turtle.getX());
        assertEquals(1, turtle.getY());
        turtle.moveForwardOneStep();
        assertEquals(0, turtle.getX());
        assertEquals(2, turtle.getY());
        assertEquals(Turtle.Orientation.SOUTH, turtle.getOrientation());
    }


}
