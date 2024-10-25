package LV4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final int DIGITS = 3;

    public static void main(String[] args) {
        ArrayList<Integer> trialList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int trialCnt = 1;
        while(true){
            BaseballGame game = new BaseballGame();
            System.out.println("\n환영합니다! 원하시는 번호를 입력해주세요.");
            System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            int num = sc.nextInt();
            if (num == 1) {
                trialList.add(game.play());
                continue;
            }
            else if (num == 2){
                System.out.println("< 게임 기록 보기 >");
                for (int t : trialList){
                    System.out.printf("%d번째 게임 : 시도 횟수 - %d\n",trialCnt++,t);
                }
                continue;
            }
            else if (num == 3) {
                System.out.println("< 숫자 야구 게임을 종료합니다. >");
                trialList.clear();
                break;
            }
            else {
                System.out.println("올바른 숫자를 입력해주세요!");
                continue;
            }

        }
    }
}
