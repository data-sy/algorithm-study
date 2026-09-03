package src.set04;

import java.util.*;

public class Ex035_12945 {

    // 문제: 피보나치 수
    // https://school.programmers.co.kr/learn/courses/30/lessons/12945

    public int solution(int n) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex035_12945 s = new Ex035_12945();

        check(1, s.solution(3), 2);
        check(2, s.solution(5), 5);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
