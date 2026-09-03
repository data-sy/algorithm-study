package src.set05;

import java.util.*;

public class Ex045_43165 {

    // 문제: 타겟 넘버
    // https://school.programmers.co.kr/learn/courses/30/lessons/43165

    public int solution(int[] numbers, int target) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex045_43165 s = new Ex045_43165();

        check(1, s.solution(new int[]{1, 1, 1, 1, 1}, 3), 5);
        check(2, s.solution(new int[]{4, 1, 2, 1}, 4), 2);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
