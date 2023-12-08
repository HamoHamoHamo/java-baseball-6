package baseball.domain;

import static baseball.constants.GameSetting.MAX_NUMBER;
import static baseball.constants.GameSetting.MIN_NUMBER;
import static baseball.constants.GameSetting.NUMBER_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ComputerNumbers {
    private final Numbers numbers;

    private ComputerNumbers(Numbers numbers) {
        this.numbers = numbers;
    }

    public static ComputerNumbers generateComputerNumbers() {
        return new ComputerNumbers(generateRandomNumbers());
    }

    private static Numbers generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < NUMBER_SIZE.getNumberValue()) {
            int randomNumber = Randoms.pickNumberInRange(
                    MIN_NUMBER.getNumberValue(), MAX_NUMBER.getNumberValue()
            );
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        System.out.println(numbers);
        return new Numbers(numbers);
    }

    public HashMap<String, Integer> comparePlayerNumbers(Numbers playerNumbers) {
        return numbers.compareNumbers(playerNumbers);
    }
}
