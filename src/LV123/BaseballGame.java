package LV123;

import java.util.Scanner;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class BaseballGame {
    private static final int DIGITS = 3;
    private Set<Integer> answerSet;
    private ArrayList<Integer> answerList;
    private int[] record = new int[DIGITS];

    // 객체 생성시 정답을 만들도록 함
    public BaseballGame() {
        answerSet = new HashSet<>();
        Random random = new Random();
        while (answerSet.size() != 3) {
            answerSet.add(random.nextInt(9) + 1);
        }
        // HashSet을 ArrayList로 변환
        answerList = new ArrayList<>(answerSet);
    }

    public int play() {
        Scanner sc = new Scanner(System.in);
        int trial = 0;
        System.out.println("< 게임을 시작합니다 >");
        while (true) {
            // 1. 유저에게 입력값을 받음
            int strike = 0, ball = 0;
            System.out.print("숫자를 입력하세요 : ");
            int input = sc.nextInt();
            for (int i=DIGITS-1;i>=0;i--){
                record[i] = input%10;
                input /= 10;
            }

            // 2. 올바른 입력값을 받았는지 검증
            if (!validateInput(input)) continue;

            // 3. 시도횟수 증가
            trial++;

            // 4. 스트라이크 개수 계산
            for (int i=0;i<DIGITS;i++){
                for (int j=0;j<DIGITS;j++){
                    if (record[i] == answerList.get(j)) {
                        if (i == j) strike++;
                        else ball++;
                    }
                }
            }
            // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
            if (strike == 3) {
                System.out.println("축하합니다. 정답입니다.");
                break;
            }
            // 6. 볼 개수 계산
            if ((strike == 0)&&(ball == 0)) System.out.print("out");
            if (strike != 0)  System.out.print(strike+" strike ");
            if (ball != 0) System.out.print(ball+" ball ");
            System.out.println();
            // 7. 힌트 출력
        }
        // 게임 진행횟수 반환
        return trial;
    }

    protected boolean validateInput(int input) {
        //자릿수 검사1 - for문에서 input을 3번 돌린 후에도 값이 남아 있을 경우 세 자리 초과.
        if (input != 0) {
            System.out.println("세 자리 수가 아닙니다. 다시 입력해주세요.");
            return false;
        }
        //자릿수 검사2 - for문에서 input을 3번 돌렸을 때 0 값이 들어갔을 경우 세 자리 미만.
        if (record[0]==0 || record[1] == 0 || record[2] == 0) {
            System.out.println("세 자리 수가 아닙니다. 다시 입력해주세요.");
            return false;
        }
        // 중복된 숫자 검사
        else if (record[0]==record[1] || record[0] == record[2] || record[1] == record[2]) {
            System.out.println("중복된 값을 입력하였습니다. 다시 입력해주세요.");
            return false;
        }
        return true;
    }
}

