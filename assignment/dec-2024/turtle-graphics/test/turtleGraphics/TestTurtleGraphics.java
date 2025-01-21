package turtleGraphics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestTurtleGraphics {
    @Test
    public void testTurtleGraphic_Exist() {
        new TurtleGraphics();
    }

    @Test
    public void testTurtleGraphic_FloorHasBeenInitialized() {
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


