package src.set04;

import java.util.*;

public class Ex034_42884 {

    // 문제: 단속카메라
    // https://school.programmers.co.kr/learn/courses/30/lessons/42884

    public int solution(int[][] routes) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex034_42884 s = new Ex034_42884();

        check(1, s.solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}), 2);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
