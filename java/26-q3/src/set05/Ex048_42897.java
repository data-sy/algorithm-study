package src.set05;

import java.util.*;

public class Ex048_42897 {

    // 문제: 도둑질
    // https://school.programmers.co.kr/learn/courses/30/lessons/42897
    // 키워드: DP - 원형이라 첫 집을 터는 경우와 안 터는 경우로 나눠 각각 선형 DP
    // 레벨: Lv.4 (동적계획법(Dynamic Programming))
    //
    // 제한사항
    // - 이 마을에 있는 집은 3개 이상 1,000,000개 이하
    // - money 배열의 각 원소는 0 이상 1,000 이하인 정수

    public int solution(int[] money) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex048_42897 s = new Ex048_42897();

        check(1, s.solution(new int[]{1, 2, 3, 1}), 4);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
