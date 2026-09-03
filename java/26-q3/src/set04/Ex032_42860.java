package src.set04;

import java.util.*;

public class Ex032_42860 {

    // 문제: 조이스틱
    // https://school.programmers.co.kr/learn/courses/30/lessons/42860

    public int solution(String name) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex032_42860 s = new Ex032_42860();

        check(1, s.solution("JEROEN"), 56);
        check(2, s.solution("JAN"), 23);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
