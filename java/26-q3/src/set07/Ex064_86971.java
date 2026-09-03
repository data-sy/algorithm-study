package src.set07;

import java.util.*;

public class Ex064_86971 {

    // 문제: 전력망을 둘로 나누기
    // https://school.programmers.co.kr/learn/courses/30/lessons/86971

    public int solution(int n, int[][] wires) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex064_86971 s = new Ex064_86971();

        check(1, s.solution(9, new int[][]{
                {1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}), 3);
        check(2, s.solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}), 0);
        check(3, s.solution(7, new int[][]{
                {1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}), 1);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
