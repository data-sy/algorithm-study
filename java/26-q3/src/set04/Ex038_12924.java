package src.set04;

import java.util.*;

public class Ex038_12924 {

    // 문제: 숫자의 표현
    // https://school.programmers.co.kr/learn/courses/30/lessons/12924

    public int solution(int n) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex038_12924 s = new Ex038_12924();

        check(1, s.solution(15), 4);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
