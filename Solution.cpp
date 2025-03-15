
#include <span>
#include <array>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {

    static const int NOT_FOUND = -1;
    static constexpr array<int, 2> RANGE_OF_VALUES = { 1, 50 };

public:
    int largestInteger(const vector<int>& input, int targetSizeSubarray) const {
        if (targetSizeSubarray == input.size()) {
            return *ranges::max_element(input);
        }

        array<int, RANGE_OF_VALUES[1] + 1> frequency{};
        for (const auto& value : input) {
            ++frequency[value];
        }

        if (targetSizeSubarray == 1) {
            return findMaxUniqueValueAmongAllElements(frequency);
        }
        return findMaxUniqueValueBetweenFirstAndLastElement(frequency, input);
    }

private:
    int findMaxUniqueValueAmongAllElements(span<const int> frequency) const {
        for (int value = RANGE_OF_VALUES[1]; value >= RANGE_OF_VALUES[0]; --value) {
            if (frequency[value] == 1) {
                return value;
            }
        }
        return NOT_FOUND;
    }

    int findMaxUniqueValueBetweenFirstAndLastElement(span<const int> frequency, span<const int> input) const {
        int firstValue = frequency[input[0]] == 1 ? input[0] : NOT_FOUND;
        int lastValue = frequency[input[input.size() - 1]] == 1 ? input[input.size() - 1] : NOT_FOUND;
        return max(firstValue, lastValue);
    }
};
