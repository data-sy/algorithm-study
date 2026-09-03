package src.set05;

import java.util.*;

public class Ex044_42839 {

    // 문제: 소수 찾기
    // https://school.programmers.co.kr/learn/courses/30/lessons/42839

    public int solution(String numbers) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex044_42839 s = new Ex044_42839();

        check(1, s.solution("17"), 3);
        check(2, s.solution("011"), 2);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
