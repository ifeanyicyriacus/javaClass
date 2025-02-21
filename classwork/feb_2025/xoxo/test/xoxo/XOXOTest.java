package xoxo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class XOXOTest {
    private final char[][] board = {
            {'X', 'O', 'X'},
            {'X', 'X', 'O'},
            {'X', 'O', 'O'}
    };

    @Test
    public void testXOXOConvertsXsTo1sAndOsTo0s() {
        XOXO xoxo = new XOXO(board);
        char[][] expected = {
                {'1', '0', '1'},
                {'1', '1', '0'},
                {'1', '0', '0'}
        };
        assertArrayEquals(xoxo.getBoard(), expected);
    }

}
