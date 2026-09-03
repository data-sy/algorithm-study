package src.set08;

import java.util.*;

public class Ex075_131705 {

    // 문제: 삼총사
    // https://school.programmers.co.kr/learn/courses/30/lessons/131705

    public int solution(int[] number) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex075_131705 s = new Ex075_131705();

        check(1, s.solution(new int[]{-2, 3, 0, 2, -5}), 2);
        check(2, s.solution(new int[]{-3, -2, -1, 0, 1, 2, 3}), 5);
        check(3, s.solution(new int[]{-1, 1, -1, 1}), 0);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
