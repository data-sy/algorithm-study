package src.set05;

import java.util.*;

public class Ex049_43162 {

    // 문제: 네트워크
    // https://school.programmers.co.kr/learn/courses/30/lessons/43162

    public int solution(int n, int[][] computers) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex049_43162 s = new Ex049_43162();

        check(1, s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}), 2);
        check(2, s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}), 1);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
