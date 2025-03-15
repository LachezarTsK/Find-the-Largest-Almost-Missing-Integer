
import kotlin.math.max

class Solution {

    private companion object {
        const val NOT_FOUND = -1
        val RANGE_OF_VALUES = intArrayOf(1, 50)
    }

    fun largestInteger(input: IntArray, targetSizeSubarray: Int): Int {
        if (targetSizeSubarray == input.size) {
            return input.max()
        }

        val frequency = IntArray(RANGE_OF_VALUES[1] + 1)
        for (value in input) {
            ++frequency[value]
        }

        if (targetSizeSubarray == 1) {
            return findMaxUniqueValueAmongAllElements(frequency)
        }
        return findMaxUniqueValueBetweenFirstAndLastElement(frequency, input)
    }

    private fun findMaxUniqueValueAmongAllElements(frequency: IntArray): Int {
        for (value in RANGE_OF_VALUES[1] downTo (RANGE_OF_VALUES[0])) {
            if (frequency[value] == 1) {
                return value
            }
        }
        return NOT_FOUND
    }

    private fun findMaxUniqueValueBetweenFirstAndLastElement(frequency: IntArray, input: IntArray): Int {
        val firstValue = if (frequency[input[0]] == 1) input[0] else NOT_FOUND
        val lastValue = if (frequency[input[input.size - 1]] == 1) input[input.size - 1] else NOT_FOUND
        return max(firstValue, lastValue)
    }
}
