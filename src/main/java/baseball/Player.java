package baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
public class Player {
    public String getNums(int length) {
        System.out.print("숫자를 입력해주세요 : ");
        String playerNums = Console.readLine();

        if (playerNums.length() != length)
            throw new IllegalArgumentException();
        try {
            System.out.println("PARSE" + Integer.parseInt(playerNums));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        return (playerNums);
    }
    public static String compareNumList(int length, List<Integer> randomNumList, String playerNums) {
        for (int i = 0; i < length; i++) {
            randomNumList.get(i);
        }
    }

    public static String compareStrike()
}
