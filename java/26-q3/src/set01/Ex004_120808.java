package src.set01;

import java.util.*;

public class Ex004_120808 {

    // 문제: 분수의 덧셈
    // https://school.programmers.co.kr/learn/courses/30/lessons/120808

    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};
        int numer = numer1*denom2 + denom1*numer2;
        int demon = denom1*denom2;

        int gcd = numer;
        int q = demon;
        int r = q;
        while (r!=0) {
            r = gcd%q;
            gcd = q;
            q = r;
        }

        return new int[]{numer/gcd, demon/gcd};
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex004_120808 s = new Ex004_120808();

        check(1, s.solution(1, 2, 3, 4), new int[]{5, 4});
        check(2, s.solution(9, 2, 1, 3), new int[]{29, 6});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
