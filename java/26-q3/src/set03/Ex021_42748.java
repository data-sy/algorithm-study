package src.set03;

import java.util.*;

public class Ex021_42748 {

    // 문제: K번째수
    // https://school.programmers.co.kr/learn/courses/30/lessons/42748

    public int[] solution(int[] array, int[][] commands) {
        // TODO: 풀이 작성
        return new int[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex021_42748 s = new Ex021_42748();

        check(1, s.solution(
                new int[]{1, 5, 2, 6, 3, 7, 4},
                new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}), new int[]{5, 6, 3});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
