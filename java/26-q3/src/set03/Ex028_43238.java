package src.set03;

import java.util.*;

public class Ex028_43238 {

    // 문제: 입국심사
    // https://school.programmers.co.kr/learn/courses/30/lessons/43238

    public long solution(int n, int[] times) {
        // TODO: 풀이 작성
        return 0L;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex028_43238 s = new Ex028_43238();

        check(1, s.solution(6, new int[]{7, 10}), 28L);
    }

    private static void check(int no, long actual, long expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
