package LV0;

import java.util.Scanner;
import java.util.Random;

public class Main {
    private static final int DIGITS = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int[] record = new int[DIGITS];
        // 정답 숫자 세 자리 생성
        int[] answer = new int[DIGITS];
        for (int i=0;i<DIGITS;i++){
            answer[i] = random.nextInt(9) + 1;
        }
        //숫자 입력 받기
        while (true) {
            int strike = 0, ball = 0;
            int input = sc.nextInt();
            for (int i=DIGITS-1;i>=0;i--){
                record[i] = input%10;
                input /= 10;
            }
            // 동일 값 예외 처리
            if (((record[0] == record[1])||(record[0] == record[2]))||(record[1] == record[2])) {
                System.out.println("동일한 숫자는 입력될 수 없습니다.");
                continue;
            }
            // 스트라이크 조건
            for (int i=0;i<DIGITS;i++){
                for (int j=0;j<DIGITS;j++){
                    if (record[i] == answer[j]) {
                        if (i == j) strike++;
                        else ball++;
                    }
                }
            }
            if (strike == 3) {
                System.out.println("축하합니다. 정답입니다.");
                break;
            }
            if ((strike == 0)&&(ball == 0)) System.out.print("out");
            if (strike != 0)  System.out.print(strike+" strike ");
            if (ball != 0) System.out.print(ball+" ball ");
            System.out.println();
        }
    }
}
