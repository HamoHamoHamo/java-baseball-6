package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static final int LENGTH = 3;
    public static void setRandomNumList(List<Integer> randomNumList) {
        randomNumList.clear();
        int randomNum;
        while (randomNumList.size() < LENGTH) {
            randomNum = Randoms.pickNumberInRange(1, 9);
            if (!randomNumList.contains(randomNum)) {
                randomNumList.add(randomNum);
            }
        }
    }
}
