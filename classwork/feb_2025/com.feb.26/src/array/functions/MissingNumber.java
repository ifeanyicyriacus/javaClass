package array.functions;

import java.util.ArrayList;
import java.util.Arrays;

public class MissingNumber {

    public static int[] getMissingNumbers(int[] input) {
        Arrays.sort(input);
        ArrayList<Integer> inputList = new ArrayList<>();
        for (int number : input) {
            inputList.add(number);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < inputList.size() - 1; i++) {
            if (inputList.get(i+1) - inputList.get(i) != 1) {
                result.add(inputList.get(i) + 1);
                inputList.add(inputList.get(i) + 1);

                Arrays.sort(input);
            }
        }
        return result;
    }
}
