package src.Lv2;

import java.util.*;

public class Ex045_43165 {

    // 문제: 타겟 넘버
    // https://school.programmers.co.kr/learn/courses/30/lessons/43165
    // 키워드: DFS·브루트포싱 - 각 숫자에 +/-를 붙여 target이 되는 경우의 수
    // 레벨: Lv.2 (깊이/너비 우선 탐색(DFS/BFS))
    //
    // 제한사항
    // - 주어지는 숫자의 개수는 2개 이상 20개 이하
    // - 각 숫자는 1 이상 50 이하인 자연수
    // - 타겟 넘버는 1 이상 1000 이하인 자연수

    public int solution(int[] numbers, int target) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex045_43165 s = new Ex045_43165();

        check(1, s.solution(new int[]{1, 1, 1, 1, 1}, 3), 5);
        check(2, s.solution(new int[]{4, 1, 2, 1}, 4), 2);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
