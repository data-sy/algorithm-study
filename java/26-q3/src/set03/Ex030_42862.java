package src.set03;

import java.util.*;

public class Ex030_42862 {

    // 문제: 체육복
    // https://school.programmers.co.kr/learn/courses/30/lessons/42862

    public int solution(int n, int[] lost, int[] reserve) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex030_42862 s = new Ex030_42862();

        check(1, s.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}), 5);
        check(2, s.solution(5, new int[]{2, 4}, new int[]{3}), 4);
        check(3, s.solution(3, new int[]{3}, new int[]{1}), 2);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
