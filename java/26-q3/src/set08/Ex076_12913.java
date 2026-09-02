package src.set08;

import java.util.*;

public class Ex076_12913 {

    // 문제: 땅따먹기
    // https://school.programmers.co.kr/learn/courses/30/lessons/12913
    // 키워드: DP - 같은 열을 연속으로 못 밟으므로 행마다 "직전 열을 뺀 최댓값"을 누적
    // 레벨: Lv.2 (연습문제)
    //
    // 제한사항
    // - 행의 개수 N은 100,000 이하의 자연수
    // - 열의 개수는 4개이고, 땅(land)은 2차원 배열로 주어짐
    // - 점수는 100 이하의 자연수

    public int solution(int[][] land) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex076_12913 s = new Ex076_12913();

        check(1, s.solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}), 16);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
