package src.set06;

import java.util.*;

public class Ex051_1829 {

    // 문제: 카카오프렌즈 컬러링북
    // https://school.programmers.co.kr/learn/courses/30/lessons/1829

    public int[] solution(int m, int n, int[][] picture) {
        // TODO: 풀이 작성
        return new int[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex051_1829 s = new Ex051_1829();

        check(1, s.solution(6, 4, new int[][]{
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}}), new int[]{4, 5});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
