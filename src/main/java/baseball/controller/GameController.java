package baseball.controller;

import static baseball.constants.GameSetting.FINISH;
import static baseball.constants.GameSetting.NUMBER_SIZE;
import static baseball.constants.GameSetting.RESTART;
import static baseball.constants.OutputMessage.BALL;
import static baseball.constants.OutputMessage.NOTHING;
import static baseball.constants.OutputMessage.STRIKE;

import baseball.domain.ComputerNumbers;
import baseball.domain.Numbers;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.HashMap;

public class GameController {

    public void run() {
        OutputView.printGameStartMessage();
        boolean loop = true;
        while (loop) {
            ComputerNumbers computerNumbers = ComputerNumbers.generateComputerNumbers();
            loop = play(computerNumbers);
        }

    }

    private boolean play(ComputerNumbers computerNumbers) {
        while(true) {
            Numbers playerNumbers = new Numbers(InputView.inputGameNumber());
            HashMap<String, Integer> result = computerNumbers.comparePlayerNumbers(playerNumbers);

            printCompareResult(result);

            if (result.get("strike") == NUMBER_SIZE.getNumberValue() && result.get("ball") == 0) {
                return selectRestartOrFinish();
            }
        }
    }

    private void printCompareResult(HashMap<String, Integer> result) {
        if (result.get("ball") > 0) {
            OutputView.printMessage("%d%s".formatted(result.get("ball"), BALL.getMessage()));
        }
        if (result.get("ball") > 0 && result.get("strike") > 0) {
            OutputView.printMessage(" ");
        }
        if (result.get("strike") > 0) {
            OutputView.printMessage("%d%s".formatted(result.get("strike"), STRIKE.getMessage()));
        }
        if (result.get("strike") == 0 && result.get("ball") == 0 ) {
            OutputView.printMessage(NOTHING.getMessage());
        }
        OutputView.printNewLine();
    }

    private boolean selectRestartOrFinish() {
        String restartValue = InputView.inputRestart();
        if (restartValue.equals(FINISH.getValue())) {
            return false;
        }
        return true;
    }
}
