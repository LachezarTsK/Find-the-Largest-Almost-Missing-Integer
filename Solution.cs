
using System;

public class Solution
{
    private static readonly int NOT_FOUND = -1;
    private static readonly int[] RANGE_OF_VALUES = { 1, 50 };

    public int LargestInteger(int[] input, int targetSizeSubarray)
    {
        if (targetSizeSubarray == input.Length)
        {
            return input.Max();
        }

        int[] frequency = new int[RANGE_OF_VALUES[1] + 1];
        foreach (int value in input)
        {
            ++frequency[value];
        }

        if (targetSizeSubarray == 1)
        {
            return FindMaxUniqueValueAmongAllElements(frequency);
        }
        return FindMaxUniqueValueBetweenFirstAndLastElement(frequency, input);
    }

    private int FindMaxUniqueValueAmongAllElements(int[] frequency)
    {
        for (int value = RANGE_OF_VALUES[1]; value >= RANGE_OF_VALUES[0]; --value)
        {
            if (frequency[value] == 1)
            {
                return value;
            }
        }
        return NOT_FOUND;
    }

    private int FindMaxUniqueValueBetweenFirstAndLastElement(int[] frequency, int[] input)
    {
        int firstValue = frequency[input[0]] == 1 ? input[0] : NOT_FOUND;
        int lastValue = frequency[input[input.Length - 1]] == 1 ? input[input.Length - 1] : NOT_FOUND;
        return Math.Max(firstValue, lastValue);
    }
}
