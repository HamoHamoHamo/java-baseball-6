package baseball.view;

import static baseball.constants.OutputMessage.INPUT_GAME_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {
    public static List<Integer> inputGameNumber() {
        OutputView.printInputGameNumberMessage();
        String input = Console.readLine();
        return parseGameNumber(input);
    }

    public static String inputRestart() {
        OutputView.printRestartMessage();
        String input = Console.readLine();
        validateInputRestart(input);
        return input;
    }

    private static void validateInputRestart(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> parseGameNumber(String input) {
        List<Integer> gameNumbers = inputToInt(toList(input));
        checkRange(gameNumbers);
        return gameNumbers;
    }

    private static List<String> toList(String input) {
        List<String> numbers = Arrays.asList(input.split(""));
        Set<String> set = new HashSet<>(numbers);
        int removeDuplicateSize = new ArrayList<>(set).size();

        if (numbers.size() != removeDuplicateSize) {
            throw new IllegalArgumentException();
        }
        return numbers;
    }

    private static List<Integer> inputToInt(List<String> inputs) {
        List<Integer> result = new ArrayList<>();

        for (String input : inputs) {
            try {
                result.add(Integer.parseInt(input));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
        }
        return result;
    }

    private static void checkRange(List<Integer> gameNumbers) {
        if (gameNumbers.stream().anyMatch(number -> number < 1 || number > 9)) {
            throw new IllegalArgumentException();
        }
    }
}
