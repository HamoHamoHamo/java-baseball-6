package baseball;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final int LENGTH = 3;
    public static void main(String[] args) {
        int status = 1;
        String playerNums;
        Player player = new Player();
        List<Integer> randomNumList = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer.setRandomNumList(randomNumList);
//        System.out.println("랜덤 숫자 확인 " + randomNumList);
        while(status == 1) {
            player.getNums();
//            System.out.println("입력값이 올바르지 않습니다.");
//            throw new IllegalArgumentException();
//                break;
            if (!player.correctCheck(randomNumList))
                continue;
            try {
                status = player.finishGame();
            } catch (IllegalArgumentException e) {
                System.out.println("입력값이 올바르지 않습니다.");
                throw new IllegalArgumentException();
//                break;
            }
            if (status == 1) {
                Computer.setRandomNumList(randomNumList);
//                System.out.println("랜덤 숫자 확인 " + randomNumList);
                System.out.println("숫자 야구 게임을 시작합니다.");
            }

        }
    }
}
