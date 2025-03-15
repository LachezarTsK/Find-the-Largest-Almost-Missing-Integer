
import java.util.Arrays;

public class Solution {

    private static final int NOT_FOUND = -1;
    private static final int[] RANGE_OF_VALUES = {1, 50};

    public int largestInteger(int[] input, int targetSizeSubarray) {
        if (targetSizeSubarray == input.length) {
            return Arrays.stream(input).max().getAsInt();
        }

        int[] frequency = new int[RANGE_OF_VALUES[1] + 1];
        for (int value : input) {
            ++frequency[value];
        }

        if (targetSizeSubarray == 1) {
            return findMaxUniqueValueAmongAllElements(frequency);
        }
        return findMaxUniqueValueBetweenFirstAndLastElement(frequency, input);
    }

    private int findMaxUniqueValueAmongAllElements(int[] frequency) {
        for (int value = RANGE_OF_VALUES[1]; value >= RANGE_OF_VALUES[0]; --value) {
            if (frequency[value] == 1) {
                return value;
            }
        }
        return NOT_FOUND;
    }

    private int findMaxUniqueValueBetweenFirstAndLastElement(int[] frequency, int[] input) {
        int firstValue = frequency[input[0]] == 1 ? input[0] : NOT_FOUND;
        int lastValue = frequency[input[input.length - 1]] == 1 ? input[input.length - 1] : NOT_FOUND;
        return Math.max(firstValue, lastValue);
    }
}
