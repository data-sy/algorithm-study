package src.set04;

import java.util.*;

public class Ex039_42840 {

    // 문제: 모의고사
    // https://school.programmers.co.kr/learn/courses/30/lessons/42840

    public int[] solution(int[] answers) {
        // TODO: 풀이 작성
        return new int[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex039_42840 s = new Ex039_42840();

        check(1, s.solution(new int[]{1, 2, 3, 4, 5}), new int[]{1});
        check(2, s.solution(new int[]{1, 3, 2, 4, 2}), new int[]{1, 2, 3});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
