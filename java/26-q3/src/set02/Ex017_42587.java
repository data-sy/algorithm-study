package src.set02;

import java.util.*;

public class Ex017_42587 {

    // 문제: 프로세스
    // https://school.programmers.co.kr/learn/courses/30/lessons/42587

    public int solution(int[] priorities, int location) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex017_42587 s = new Ex017_42587();

        check(1, s.solution(new int[]{2, 1, 3, 2}, 2), 1);
        check(2, s.solution(new int[]{1, 1, 9, 1, 1, 1}, 0), 5);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
