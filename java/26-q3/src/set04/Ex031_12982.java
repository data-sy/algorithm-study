package src.set04;

import java.util.*;

public class Ex031_12982 {

    // 문제: 예산
    // https://school.programmers.co.kr/learn/courses/30/lessons/12982

    public int solution(int[] d, int budget) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex031_12982 s = new Ex031_12982();

        check(1, s.solution(new int[]{1, 3, 2, 5, 4}, 9), 3);
        check(2, s.solution(new int[]{2, 2, 3, 3}, 10), 4);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
