package baseball.domain;

import static baseball.constants.GameSetting.MAX_NUMBER;
import static baseball.constants.GameSetting.MIN_NUMBER;
import static baseball.constants.GameSetting.NUMBER_SIZE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateDuplicate(numbers);
        validateSize(numbers);
        validateValue(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        int removeDuplicateSize = new ArrayList<>(set).size();
        if (numbers.size() != removeDuplicateSize) {
            throw new IllegalArgumentException();
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE.getNumberValue()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateValue(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < MIN_NUMBER.getNumberValue() ||
                number > MAX_NUMBER.getNumberValue())
        ) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public HashMap<String, Integer> compareNumbers(Numbers otherNumbers) {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("strike", 0);
        result.put("ball", 0);

        for (int i = 0; i < NUMBER_SIZE.getNumberValue(); i++) {
            compareNumber(otherNumbers.getNumbers().get(i), i, result);
        }
        return result;
    }

    private void compareNumber(int otherNumber, int i, HashMap<String, Integer> result) {
        for (int j = 0; j < NUMBER_SIZE.getNumberValue(); j++) {
            if (numbers.get(j) == otherNumber && i == j) {
                result.put("strike", result.get("strike") + 1);
                break;
            }
            if (numbers.get(j) == otherNumber) {
                result.put("ball", result.get("ball") + 1);
                break;
            }
        }
    }
}
