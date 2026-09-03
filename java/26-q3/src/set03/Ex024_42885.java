package src.set03;

import java.util.*;

public class Ex024_42885 {

    // 문제: 구명보트
    // https://school.programmers.co.kr/learn/courses/30/lessons/42885

    public int solution(int[] people, int limit) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex024_42885 s = new Ex024_42885();

        check(1, s.solution(new int[]{70, 50, 80, 50}, 100), 3);
        check(2, s.solution(new int[]{70, 80, 50}, 100), 3);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
