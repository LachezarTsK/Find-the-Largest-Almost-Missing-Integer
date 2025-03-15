
package main

import "slices"

const NOT_FOUND = -1

var RANGE_OF_VALUES = [2]int{1, 50}

func largestInteger(input []int, targetSizeSubarray int) int {
    if targetSizeSubarray == len(input) {
        return slices.Max(input)
    }

    frequency := make([]int, RANGE_OF_VALUES[1]+1)
    for _, value := range input {
        frequency[value]++
    }

    if targetSizeSubarray == 1 {
        return findMaxUniqueValueAmongAllElements(frequency)
    }
    return findMaxUniqueValueBetweenFirstAndLastElement(frequency, input)
}

func findMaxUniqueValueAmongAllElements(frequency []int) int {
    for value := RANGE_OF_VALUES[1]; value >= RANGE_OF_VALUES[0]; value-- {
        if frequency[value] == 1 {
            return value
        }
    }
    return NOT_FOUND
}

func findMaxUniqueValueBetweenFirstAndLastElement(frequency []int, input []int) int {
    firstValue := Ternary((frequency[input[0]] == 1), input[0], NOT_FOUND)
    lastValue := Ternary((frequency[input[len(input)-1]] == 1), input[len(input)-1], NOT_FOUND)
    return max(firstValue, lastValue)
}

func Ternary[T any](condition bool, first T, second T) T {
    if condition {
        return first
    }
    return second
}
