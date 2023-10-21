package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static List<Integer> setRandomNumList(int length) {
        List<Integer> randomNumList = new ArrayList<>();
        int randomNum;
        while (randomNumList.size() < length) {
            randomNum = Randoms.pickNumberInRange(1, 9);
            if (!randomNumList.contains(randomNum)) {
                randomNumList.add(randomNum);
            }
        }
        return (randomNumList);
    }
}
