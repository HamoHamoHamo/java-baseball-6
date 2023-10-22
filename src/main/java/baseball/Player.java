package baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
public class Player {
    static final int LENGTH = 3;
    static List<Integer> playerNumList = new ArrayList<>();
    static int strike;
    static int ball;

    public void getNums() {
        strike = 0;
        ball = 0;
        String playerNums;
        playerNumList.clear();
        System.out.print("서로 다른 3자리의 수를 입력해주세요 : ");
        playerNums = Console.readLine();

        if (playerNums.length() != LENGTH)
            throw new IllegalArgumentException();
        try {
            Integer.parseInt(playerNums);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < LENGTH; i++) {
            playerNumList.add(playerNums.charAt(i) - '0');
        }
        if(playerNumList.size() != playerNumList.stream().distinct().count()){
            throw new IllegalArgumentException();
        }
    }
    public boolean correctCheck(List<Integer> randomNumList) {
        for (int i = 0; i < LENGTH; i++) {
            compareNum(i, randomNumList.get(i));
        }
        if (ball > 0) {
            System.out.print(ball + "볼");
            System.out.print(" ");
        }
        if (strike > 0)
            System.out.print(strike + "스트라이크");
        if (ball == 0 && strike == 0)
            System.out.print("낫싱");
        System.out.println();
        if (strike == 3)
            return (true);
        return (false);
    }

    public static void compareNum(int idx, int computerNum) {
        int num;
        for (int i = 0; i < LENGTH; i++) {
            num = playerNumList.get(i);
            if (computerNum == num && idx == i) {
                strike++;
            } else if (computerNum == num) {
                ball++;
            }
        }
    }
    public int finishGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String readStatus = Console.readLine();

        int status;
        if (!readStatus.equals("1") && !readStatus.equals("2"))
            throw new IllegalArgumentException();

        try {
            status = Integer.parseInt(readStatus);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        return (status);
    }
}
