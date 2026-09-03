package src.set02;

import java.util.*;

public class Ex020_42627 {

    // 문제: 디스크 컨트롤러
    // https://school.programmers.co.kr/learn/courses/30/lessons/42627

    public int solution(int[][] jobs) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex020_42627 s = new Ex020_42627();

        check(1, s.solution(new int[][]{{0, 3}, {1, 9}, {3, 5}}), 8);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
