package src.set03;

import java.util.*;

public class Ex022_42747 {

    // 문제: H-Index
    // https://school.programmers.co.kr/learn/courses/30/lessons/42747

    public int solution(int[] citations) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex022_42747 s = new Ex022_42747();

        check(1, s.solution(new int[]{3, 0, 6, 1, 5}), 3);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
