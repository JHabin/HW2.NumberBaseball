/**
 * 숫자 야구 BaseballGame 클래스로 분리하여 구현
 * 정답 랜덤 값 생성시 HashSet 사용 -> ArrayList 에 저장
 * 0 - 자릿수 설정 후 게임 시작
 * 1 - 자릿수 3으로 고정하여 게임 시작
 * 2 - 시도 횟수 기록 출력
 * 3 - 반복 종료
 */
package LV4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> trialList = new ArrayList<>();   //시도 횟수 저장 리스트 생성
        Scanner sc = new Scanner(System.in);
        int trialCnt = 1;
        boolean flag = true;    // 탈출 flag 설정
        while(flag){
            int digits = 3;    // 기본 자릿수 3으로 고정
            System.out.println("\n환영합니다! 원하시는 번호를 입력해주세요.");
            System.out.println("0. 자릿수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            int num = sc.nextInt();
            switch(num){
                case 0:
                    System.out.println("설정하고자 하는 자리수를 입력하세요.");
                    digits = sc.nextInt();
                    if (!(2 < digits && digits < 6)) break; // 3자리 ~ 5자리만 입력 가능
                case 1:
                    BaseballGame game = new BaseballGame(digits);   // 객체 생성
                    trialList.add(game.play());     // 게임 진행
                    break;
                case 2:
                    System.out.println("< 게임 기록 보기 >");
                    for (int t : trialList) {
                        System.out.printf("%d번째 게임 : 시도 횟수 - %d\n", trialCnt++, t);
                    }
                    break;
                case 3:
                    System.out.println("< 숫자 야구 게임을 종료합니다. >");
                    trialList.clear();  // 종료 시 시도횟수 리스트 내용 삭제
                    flag = false;   // while문 종료
                    break;
                default:
                    System.out.println("올바른 숫자를 입력해주세요!");
                    break;
            }

        }
    }
}
