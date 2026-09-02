package src.set03;

import java.util.*;

public class Ex026_131701 {

    // 문제: 연속 부분 수열 합의 개수
    // https://school.programmers.co.kr/learn/courses/30/lessons/131701
    // 키워드: 슬라이딩 윈도우·해시 - 원형 수열의 모든 연속 부분 수열 합을 집합에 모아 개수를 센다
    // 레벨: Lv.2 (연습문제)
    //
    // 제한사항
    // - 3 <= elements의 길이 <= 1,000
    // - 1 <= elements의 원소 <= 1,000

    public int solution(int[] elements) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex026_131701 s = new Ex026_131701();

        check(1, s.solution(new int[]{7, 9, 1, 1, 4}), 18);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
