package src.set05;

import java.util.*;

public class Ex043_87946 {

    // 문제: 피로도
    // https://school.programmers.co.kr/learn/courses/30/lessons/87946

    public int solution(int k, int[][] dungeons) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex043_87946 s = new Ex043_87946();

        check(1, s.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}), 3);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
