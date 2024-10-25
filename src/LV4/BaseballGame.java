/**
 * 숫자 야구 BaseballGame 클래스
 * 생성자 - 랜덤 정답 데이터 생성
 * play() 메서드 - 숫자 야구 수행
 * validInput() 메서드 - 테스트 값 유효성 검사
 */
package LV4;

import java.util.Scanner;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class BaseballGame {
    private Set<Integer> answerSet;     // 중복 없이 정답 생성
    private ArrayList<Integer> answerList;  // HashSet으로 생성한 정답 숫자 리스트에 저장
    private int gameDigits; // 설정한 자릿수 저장

    /* 객체 생성시 정답을 만들도록 함 */
    public BaseballGame(int digits) {
        this.gameDigits = digits;
        answerSet = new HashSet<>();
        Random random = new Random();
        while (answerSet.size() != digits) {    // 자릿수만큼 입력받기
            answerSet.add(random.nextInt(9) + 1);
        }
        // HashSet을 ArrayList로 변환
        answerList = new ArrayList<>(answerSet);

    }

    /* 숫자 야구 실행 */
    public int play() {
        Scanner sc = new Scanner(System.in);
        int trial = 0;
        int[] record = new int[gameDigits];
        System.out.println("< 게임을 시작합니다 >");
        while (true) {
            // 1. 유저에게 입력값을 받음
            int strike = 0, ball = 0;
            System.out.print("숫자를 입력하세요 : ");
            int input = sc.nextInt();
            for (int i = gameDigits - 1; i >= 0; i--) {
                record[i] = input % 10;
                input /= 10;
            }
            // 2. 올바른 입력값을 받았는지 검증
            if (!validateInput(input, record)) continue;

            // 3. 시도횟수 증가
            trial++;

            // 4. 스트라이크, 볼 개수 카운팅
            for (int i = 0; i < gameDigits; i++) {
                for (int j = 0; j < gameDigits; j++) {
                    if (record[i] == answerList.get(j)) {
                        if (i == j) strike++;
                        else ball++;
                    }
                }
            }
            // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
            if (strike == gameDigits) {
                System.out.println("축하합니다. 정답입니다.");
                break;
            }
            // 6. 볼 개수 계산
            if (strike == 0 && ball == 0) System.out.print("out");
            if (strike != 0) System.out.print(strike + " strike ");
            if (ball != 0) System.out.print(ball + " ball ");
            System.out.println();
        }
        // 게임 진행횟수 반환
        return trial;
    }
    /* 입력 데이터 유효성 검사 */
    protected boolean validateInput(int input, int[] record) {
        //자릿수 검사1 - for문에서 input을 digits번 돌린 후에도 값이 남아 있을 경우 자릿수 초과.
        if (input != 0) {
            System.out.println("자릿수가 일치하지 않습니다. 다시 입력해주세요.");
            return false;
        }
        //자릿수 검사2 - for문에서 input을 digits번 돌렸을 때 0 값이 들어갔을 경우 자릿수 미만.
        for (int r : record) {
            if (r != 0) continue;
            else {
                System.out.println("자릿수가 일치하지 않습니다. 다시 입력해주세요.");
                return false;
            }
        }
        // 중복된 숫자 검사
        for (int i = 0; i < record.length; i++) {
            for (int j = 0; j < i; j++) {
                if (record[i] == record[j]) {  // 중복 검사
                    System.out.println("중복된 값을 입력하였습니다. 다시 입력해주세요.");
                    return false;
                }
            }
        }
        return true;
    }
}