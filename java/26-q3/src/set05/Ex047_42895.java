package src.set05;

import java.util.*;

public class Ex047_42895 {

    // 문제: N으로 표현
    // https://school.programmers.co.kr/learn/courses/30/lessons/42895

    public int solution(int N, int number) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex047_42895 s = new Ex047_42895();

        check(1, s.solution(5, 12), 4);
        check(2, s.solution(2, 11), 3);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
