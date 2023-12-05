package baseball.view;

import static baseball.constants.OutputMessage.GAME_END;
import static baseball.constants.OutputMessage.GAME_START;
import static baseball.constants.OutputMessage.INPUT_GAME_NUMBER;

public class OutputView {

    public static void printGameStartMessage() {
        System.out.println(GAME_START.getMessage());
    }

    public static void printInputGameNumberMessage() {
        System.out.println(INPUT_GAME_NUMBER.getMessage());
    }

    public static void printRestartMessage() {
        System.out.println(GAME_END.getMessage());
    }
}
