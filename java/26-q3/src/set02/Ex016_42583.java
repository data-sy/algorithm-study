package src.set02;

import java.util.*;

public class Ex016_42583 {

    // 문제: 다리를 지나는 트럭
    // https://school.programmers.co.kr/learn/courses/30/lessons/42583
    // 키워드: 큐·시뮬레이션 - 다리 길이만큼의 큐를 1초씩 밀며 하중 제한을 지킨다
    // 레벨: Lv.2 (스택/큐)
    //
    // 제한사항
    // - bridge_length는 1 이상 10,000 이하
    // - weight는 1 이상 10,000 이하
    // - truck_weights의 길이는 1 이상 10,000 이하
    // - 모든 트럭의 무게는 1 이상 weight 이하

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
