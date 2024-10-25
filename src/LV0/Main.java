/**
 * 숫자 야구 컬렉션, 클래스 없이 구현
 * 랜덤 세자리 값 생성 -> 테스트 -> 정답일 시 종료
 */
package LV0;

import java.util.Scanner;
import java.util.Random;

public class Main {
    private static final int DIGITS = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int[] answer = new int[DIGITS];     // 정답의 각 자리 값 저장하는 배열
        int[] record = new int[DIGITS];     // 입력받는 숫자의 각 자리 값 저장하는 배열
        for (int i=0;i<DIGITS;i++){
            answer[i] = random.nextInt(9) + 1;  // 정답 세 자리 숫자 생성
        }
        while (true) {      // 정답 맞힐 때까지 출력
            int strike = 0, ball = 0;
            int input = sc.nextInt();   // 테스트 숫자 입력 받기
            for (int i=DIGITS-1;i>=0;i--){
                record[i] = input%10;
                input /= 10;
            }
            /* 동일 값 예외 처리 */
            if (((record[0] == record[1])||(record[0] == record[2]))||(record[1] == record[2])) {
                System.out.println("동일한 숫자는 입력될 수 없습니다.");
                continue;
            }
            /* 스트라이크, 볼 개수 세기 */
            for (int i=0;i<DIGITS;i++){
                for (int j=0;j<DIGITS;j++){
                    if (record[i] == answer[j]) {
                        if (i == j) strike++;
                        else ball++;
                    }
                }
            }
            /* 결과 출력 */
            if (strike == 3) {
                System.out.println("축하합니다. 정답입니다.");
                break;
            }
            if (strike == 0 && ball == 0) System.out.print("out");
            if (strike != 0)  System.out.print(strike + " strike ");
            if (ball != 0) System.out.print(ball + " ball ");
            System.out.println();
        }
    }
}
