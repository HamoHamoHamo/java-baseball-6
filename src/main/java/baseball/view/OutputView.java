package baseball.view;

import static baseball.constants.OutputMessage.GAME_END;
import static baseball.constants.OutputMessage.GAME_START;
import static baseball.constants.OutputMessage.INPUT_GAME_NUMBER;

public class OutputView {

    public static void printGameStartMessage() {
        System.out.println(GAME_START.getMessage());
    }

    public static void printInputGameNumberMessage() {
        System.out.print(INPUT_GAME_NUMBER.getMessage());
    }

    public static void printRestartMessage() {
        System.out.println(GAME_END.getMessage());
    }

    public static void printMessage(String message) {
        System.out.print(message);
    }
    public static void printNewLine() {
        System.out.println();
    }
}
