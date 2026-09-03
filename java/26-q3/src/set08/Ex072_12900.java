package src.set08;

import java.util.*;

public class Ex072_12900 {

    // 문제: 2 x n 타일링
    // https://school.programmers.co.kr/learn/courses/30/lessons/12900

    public long solution(int n) {
        // TODO: 풀이 작성
        return 0L;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex072_12900 s = new Ex072_12900();

        check(1, s.solution(4), 5L);
    }

    private static void check(int no, long actual, long expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
