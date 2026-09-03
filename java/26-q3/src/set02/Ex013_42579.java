package src.set02;

import java.util.*;

public class Ex013_42579 {

    // 문제: 베스트앨범
    // https://school.programmers.co.kr/learn/courses/30/lessons/42579

    public int[] solution(String[] genres, int[] plays) {
        // TODO: 풀이 작성
        return new int[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex013_42579 s = new Ex013_42579();

        check(1, s.solution(
                new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500}), new int[]{4, 1, 3, 0});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
