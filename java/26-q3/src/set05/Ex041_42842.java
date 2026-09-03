package src.set05;

import java.util.*;

public class Ex041_42842 {

    // 문제: 카펫
    // https://school.programmers.co.kr/learn/courses/30/lessons/42842

    public int[] solution(int brown, int yellow) {
        // TODO: 풀이 작성
        return new int[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex041_42842 s = new Ex041_42842();

        check(1, s.solution(10, 2), new int[]{4, 3});
        check(2, s.solution(8, 1), new int[]{3, 3});
        check(3, s.solution(24, 24), new int[]{8, 6});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
