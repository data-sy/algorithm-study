package src.set06;

import java.util.*;

public class Ex051_1829 {

    // 문제: 카카오프렌즈 컬러링북
    // https://school.programmers.co.kr/learn/courses/30/lessons/1829
    // 키워드: DFS·BFS·그래프 이론 - 같은 색으로 연결된 영역의 개수와 최대 넓이
    // 레벨: Lv.2 (2017 카카오코드 예선)
    //
    // 제한사항
    // - 1 <= m, n <= 100
    // - picture의 원소는 0 이상 2^31 - 1 이하의 임의의 값
    // - picture의 원소 중 값이 0인 경우는 색칠하지 않는 영역
    // - 반환값은 [영역의 수, 가장 큰 영역의 넓이]

    public int[] solution(int m, int n, int[][] picture) {
        // TODO: 풀이 작성
        return new int[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex051_1829 s = new Ex051_1829();

        check(1, s.solution(6, 4, new int[][]{
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}}), new int[]{4, 5});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
