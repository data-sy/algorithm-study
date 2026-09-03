package src.set07;

import java.util.*;

public class Ex067_12946 {

    // 문제: 하노이의 탑
    // https://school.programmers.co.kr/learn/courses/30/lessons/12946

    public int[][] solution(int n) {
        // TODO: 풀이 작성
        return new int[0][];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex067_12946 s = new Ex067_12946();

        check(1, s.solution(2), new int[][]{{1, 2}, {1, 3}, {2, 3}});
    }

    private static void check(int no, int[][] actual, int[][] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.deepEquals(actual, expected) ? "PASS" : "FAIL",
                Arrays.deepToString(expected), Arrays.deepToString(actual));
    }
}
