package src.set02;

import java.util.*;

public class Ex019_42628 {

    // 문제: 이중우선순위큐
    // https://school.programmers.co.kr/learn/courses/30/lessons/42628

    public int[] solution(String[] operations) {
        // TODO: 풀이 작성
        return new int[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex019_42628 s = new Ex019_42628();

        check(1, s.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}),
                new int[]{0, 0});
        check(2, s.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}),
                new int[]{333, -45});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
