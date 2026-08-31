package src.Lv2;

import java.util.*;

public class Ex018_42626 {

    // 문제: 더 맵게
    // https://school.programmers.co.kr/learn/courses/30/lessons/42626
    // 키워드: 우선순위 큐 - 가장 안 매운 두 음식을 계속 섞어 모든 음식을 K 이상으로
    // 레벨: Lv.2 (힙)
    //
    // 제한사항
    // - scoville의 길이는 2 이상 1,000,000 이하
    // - K는 0 이상 1,000,000,000 이하
    // - scoville의 원소는 각각 0 이상 1,000,000 이하
    // - 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return

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
