package src.set08;

import java.util.*;

public class Ex074_12971 {

    // 문제: 스티커 모으기(2)
    // https://school.programmers.co.kr/learn/courses/30/lessons/12971
    // 키워드: DP - 원형이라 첫 스티커를 뜯는 경우와 안 뜯는 경우로 나눠 각각 선형 DP
    // 레벨: Lv.3 (Summer/Winter Coding(~2018))
    //
    // 제한사항
    // - sticker는 원형으로 연결된 스티커의 각 칸에 적힌 숫자가 순서대로 들어있는 배열로,
    //   길이(N)는 1 이상 100,000 이하
    // - sticker의 각 원소는 1 이상 100 이하의 자연수
    // - 배열의 첫 번째 원소와 마지막 원소가 서로 연결되어 있다고 간주

    public int solution(int[] sticker) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex074_12971 s = new Ex074_12971();

        check(1, s.solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}), 36);
        check(2, s.solution(new int[]{1, 3, 2, 5, 4}), 8);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
