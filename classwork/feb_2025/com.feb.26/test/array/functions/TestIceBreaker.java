package array.functions;

import org.junit.jupiter.api.Test;

import static array.functions.IceBreaker.returnMultipleOfCBetweenAAndB;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestIceBreaker {
    @Test
    public void testIceBreakerReturnCorrectValueWhenAllInputAreValid() {
        int[] a = {1, -30, 40, 30};
        int[] b = {10, 15, 30, 50};
        int[] c = {3, 3, 10, 10};

        int[][] result = {
                {3, 6 ,9},
                {-30, -27, -24, -21, -18, -15, -12, -9, -6, -3, 0, 3, 6, 9, 12, 15},
                {},
                {30, 40, 50}
        };

        for (int i = 0; i < a.length; i++) {
            int[] actual = returnMultipleOfCBetweenAAndB(a[i], b[i], c[i]);
            int[] expected = result[i];
            assertArrayEquals(actual, expected);
        }
    }


}
