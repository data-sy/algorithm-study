package src.set02;

import java.util.*;

public class Ex018_42626 {

    // 문제: 더 맵게
    // https://school.programmers.co.kr/learn/courses/30/lessons/42626

    public int solution(int[] scoville, int K) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex018_42626 s = new Ex018_42626();

        check(1, s.solution(new int[]{1, 2, 3, 9, 10, 12}, 7), 2);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
