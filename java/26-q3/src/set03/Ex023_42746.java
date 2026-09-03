package src.set03;

import java.util.*;

public class Ex023_42746 {

    // 문제: 가장 큰 수
    // https://school.programmers.co.kr/learn/courses/30/lessons/42746

    public String solution(int[] numbers) {
        // TODO: 풀이 작성
        return "";
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex023_42746 s = new Ex023_42746();

        check(1, s.solution(new int[]{6, 10, 2}), "6210");
        check(2, s.solution(new int[]{3, 30, 34, 5, 9}), "9534330");
    }

    private static void check(int no, String actual, String expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Objects.equals(actual, expected) ? "PASS" : "FAIL", expected, actual);
    }
}
