/**
 * 자릿수 3으로 고정
 * 숫자 야구 BaseballGame 클래스로 분리하여 구현
 * 정답 랜덤 값 생성시 HashSet 사용 -> ArrayList 에 저장
 */
package LV123;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static final int DIGITS = 3;

    public static void main(String[] args) {
        ArrayList<Integer> trialList = new ArrayList<>();   //시도 횟수 저장 리스트 생성
        Scanner sc = new Scanner(System.in);
        int trialCnt = 1;
        while(true){
            System.out.println("\n환영합니다! 원하시는 번호를 입력해주세요.");
            System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            int num = sc.nextInt();
            if (num == 1) {
                BaseballGame game = new BaseballGame(); // 객체 생성
                trialList.add(game.play());     // 게임 진행
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
                trialList.clear();  // 종료 시 시도횟수 리스트 내용 삭제
                break;
            }
            else {
                System.out.println("올바른 숫자를 입력해주세요!");
                continue;
            }
        }
    }
}
