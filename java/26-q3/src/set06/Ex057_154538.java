package src.set06;

import java.util.*;

public class Ex057_154538 {

    // 문제: 숫자 변환하기
    // https://school.programmers.co.kr/learn/courses/30/lessons/154538

    public int solution(int x, int y, int n) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex057_154538 s = new Ex057_154538();

        check(1, s.solution(10, 40, 5), 2);
        check(2, s.solution(10, 40, 30), 1);
        check(3, s.solution(2, 5, 4), -1);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
