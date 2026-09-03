package src.set07;

import java.util.*;

public class Ex070_42898 {

    // 문제: 등굣길
    // https://school.programmers.co.kr/learn/courses/30/lessons/42898

    public int solution(int m, int n, int[][] puddles) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex070_42898 s = new Ex070_42898();

        check(1, s.solution(4, 3, new int[][]{{2, 2}}), 4);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
