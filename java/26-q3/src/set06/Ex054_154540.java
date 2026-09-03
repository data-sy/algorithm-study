package src.set06;

import java.util.*;

public class Ex054_154540 {

    // 문제: 무인도 여행
    // https://school.programmers.co.kr/learn/courses/30/lessons/154540

    public int[] solution(String[] maps) {
        // TODO: 풀이 작성
        return new int[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex054_154540 s = new Ex054_154540();

        check(1, s.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"}),
                new int[]{1, 1, 27});
        check(2, s.solution(new String[]{"XXX", "XXX", "XXX"}), new int[]{-1});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
