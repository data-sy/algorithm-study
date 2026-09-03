package src.set05;

import java.util.*;

public class Ex042_84512 {

    // 문제: 모음사전
    // https://school.programmers.co.kr/learn/courses/30/lessons/84512

    public int solution(String word) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex042_84512 s = new Ex042_84512();

        check(1, s.solution("AAAAE"), 6);
        check(2, s.solution("AAAE"), 10);
        check(3, s.solution("I"), 1563);
        check(4, s.solution("EIO"), 1189);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
