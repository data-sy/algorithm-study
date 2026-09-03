package src.set07;

import java.util.*;

public class Ex065_92343 {

    // 문제: 양과 늑대
    // https://school.programmers.co.kr/learn/courses/30/lessons/92343

    public int solution(int[] info, int[][] edges) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex065_92343 s = new Ex065_92343();

        check(1, s.solution(
                new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10},
                        {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}}), 5);
        check(2, s.solution(
                new int[]{0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6},
                        {3, 7}, {4, 8}, {6, 9}, {9, 10}}), 5);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
