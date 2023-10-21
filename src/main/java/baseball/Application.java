package baseball;

import baseball.Player;
import baseball.Computer;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final int LENGTH = 3;
    public static void main(String[] args) {
        int status = 1;
        String playerNums;
        Player player = new Player();
        List<Integer> randomNumList = new ArrayList<>();

        while(status == 1) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            randomNumList = Computer.setRandomNumList(LENGTH);
            try {
                playerNums = player.getNums(LENGTH);
            } catch (IllegalArgumentException e) {
                System.out.println("입력값이 올바르지 않습니다.");
                break;
            }
            System.out.println("TSET" + playerNums);

        }

    }



}
