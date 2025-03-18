package array.functions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestMissingNumber {
    private final int[][] inputs = {
            {1, 2, 5},
            {77, 78, 80,85},
            {77, 78, 79, 80}
    };

    private final int[][] results = {
            {3, 4},
            {79,81,82,83,84},
            {}
    };

    @Test
    public void testThatFindMissingNumberReturnsMissingList(){
        int[] actual;
        int[] expected;
        for (int i =0; i < results.length; i++) {
            actual = MissingNumber.getMissingNumbers(inputs[i]);
            expected = results[i];
            assertArrayEquals(actual, expected);
        }
    }
}
