package src.set07;

import java.util.*;

public class Ex066_42892 {

    // 문제: 길 찾기 게임
    // https://school.programmers.co.kr/learn/courses/30/lessons/42892

    public int[][] solution(int[][] nodeinfo) {
        // TODO: 풀이 작성
        return new int[0][];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex066_42892 s = new Ex066_42892();

        check(1, s.solution(new int[][]{
                {5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}}),
                new int[][]{{7, 4, 6, 9, 1, 8, 5, 2, 3}, {9, 6, 5, 8, 1, 4, 3, 2, 7}});
    }

    private static void check(int no, int[][] actual, int[][] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.deepEquals(actual, expected) ? "PASS" : "FAIL",
                Arrays.deepToString(expected), Arrays.deepToString(actual));
    }
}
