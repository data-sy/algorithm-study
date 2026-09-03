package src.set02;

import java.util.*;

public class Ex015_42586 {

    // 문제: 기능개발
    // https://school.programmers.co.kr/learn/courses/30/lessons/42586

    public int[] solution(int[] progresses, int[] speeds) {
        // TODO: 풀이 작성
        return new int[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex015_42586 s = new Ex015_42586();

        check(1, s.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}),
                new int[]{2, 1});
        check(2, s.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}),
                new int[]{1, 3, 2});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
