package src.set08;

import java.util.*;

public class Ex074_12971 {

    // 문제: 스티커 모으기(2)
    // https://school.programmers.co.kr/learn/courses/30/lessons/12971

    public int solution(int[] sticker) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex074_12971 s = new Ex074_12971();

        check(1, s.solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}), 36);
        check(2, s.solution(new int[]{1, 3, 2, 5, 4}), 8);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
