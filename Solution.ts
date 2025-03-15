
function largestInteger(input: number[], targetSizeSubarray: number): number {
    this.NOT_FOUND = -1;
    this.RANGE_OF_VALUES = [1, 50];

    if (targetSizeSubarray === input.length) {
        return Math.max(...input);
    }

    const frequency: number[] = new Array(this.RANGE_OF_VALUES[1] + 1).fill(0);
    for (let value of input) {
        ++frequency[value];
    }

    if (targetSizeSubarray === 1) {
        return findMaxUniqueValueAmongAllElements(frequency);
    }
    return findMaxUniqueValueBetweenFirstAndLastElement(frequency, input);
};

function findMaxUniqueValueAmongAllElements(frequency: number[]): number {
    for (let value = this.RANGE_OF_VALUES[1]; value >= this.RANGE_OF_VALUES[0]; --value) {
        if (frequency[value] === 1) {
            return value;
        }
    }
    return this.NOT_FOUND;
}

function findMaxUniqueValueBetweenFirstAndLastElement(frequency: number[], input: number[]): number {
    const firstValue = frequency[input[0]] === 1 ? input[0] : this.NOT_FOUND;
    const lastValue = frequency[input[input.length - 1]] === 1 ? input[input.length - 1] : this.NOT_FOUND;
    return Math.max(firstValue, lastValue);
}
