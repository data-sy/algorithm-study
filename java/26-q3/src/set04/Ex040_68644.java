package src.set04;

import java.util.*;

public class Ex040_68644 {

    // 문제: 두 개 뽑아서 더하기
    // https://school.programmers.co.kr/learn/courses/30/lessons/68644

    public int[] solution(int[] numbers) {
        // TODO: 풀이 작성
        return new int[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex040_68644 s = new Ex040_68644();

        check(1, s.solution(new int[]{2, 1, 3, 4, 1}), new int[]{2, 3, 4, 5, 6, 7});
        check(2, s.solution(new int[]{5, 0, 2, 7}), new int[]{2, 5, 7, 9, 12});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
