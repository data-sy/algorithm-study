package src.set02;

import java.util.*;

public class Ex016_42583 {

    // 문제: 다리를 지나는 트럭
    // https://school.programmers.co.kr/learn/courses/30/lessons/42583

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex016_42583 s = new Ex016_42583();

        check(1, s.solution(2, 10, new int[]{7, 4, 5, 6}), 8);
        check(2, s.solution(100, 100, new int[]{10}), 101);
        check(3, s.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}), 110);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
