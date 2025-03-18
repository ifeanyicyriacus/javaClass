package turtleGraphics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static turtleGraphics.Turtle.Orientation.*;
import static turtleGraphics.Turtle.PenState.DOWN;
import static turtleGraphics.Turtle.PenState.UP;

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
        assertEquals(UP, turtle.getPenState());
        assertEquals(EAST, turtle.getOrientation());
    }

    @Test
    public void testTurtle_CanTurnRight() {
        Turtle turtle = new Turtle(20, 20);
        assertEquals(EAST, turtle.getOrientation());
        turtle.turnRIGHT();
        assertEquals(SOUTH, turtle.getOrientation());
        turtle.turnRIGHT();
        assertEquals(WEST, turtle.getOrientation());
        turtle.turnRIGHT();
        assertEquals(NORTH, turtle.getOrientation());
    }

    @Test
    public void testTurtle_CanTurnLeft() {
        Turtle turtle = new Turtle(20, 20);
        assertEquals(EAST, turtle.getOrientation());
        turtle.turnLEFT();
        assertEquals(NORTH, turtle.getOrientation());
        turtle.turnLEFT();
        assertEquals(WEST, turtle.getOrientation());
        turtle.turnLEFT();
        assertEquals(SOUTH, turtle.getOrientation());
    }

    @Test
    public void testTurtle_CanPenDown() {
        Turtle turtle = new Turtle(20, 20);
        assertEquals(UP, turtle.getPenState());
        turtle.penDOWN();
        assertEquals(DOWN, turtle.getPenState());
    }

    @Test
    public void testTurtle_CanPenUp() {
        Turtle turtle = new Turtle(20, 20);
        turtle.penDOWN();
        assertEquals(DOWN, turtle.getPenState());
        turtle.penUP();
        assertEquals(UP, turtle.getPenState());
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
        assertEquals(EAST, turtle.getOrientation());
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
        assertEquals(SOUTH, turtle.getOrientation());
    }


}