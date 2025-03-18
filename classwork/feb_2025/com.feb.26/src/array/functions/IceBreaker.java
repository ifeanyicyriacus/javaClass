package array.functions;

import java.util.ArrayList;
import java.util.Arrays;

public class IceBreaker {
    public static int[] returnMultipleOfCBetweenAAndB(int a, int b, int c) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            if (i % c == 0) { result.add(i); }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
