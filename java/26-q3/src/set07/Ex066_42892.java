package src.set07;

import java.util.*;

public class Ex066_42892 {

    // 문제: 길 찾기 게임
    // https://school.programmers.co.kr/learn/courses/30/lessons/42892
    // 키워드: 트리·재귀·정렬 - y 내림차순으로 이진탐색트리를 세우고 전위·후위 순회 (재귀 깊이 주의)
    // 레벨: Lv.3 (2019 KAKAO BLIND RECRUITMENT)
    //
    // 제한사항
    // - nodeinfo는 이진트리를 구성하는 각 노드의 좌표가 1번 노드부터 순서대로 들어있는 2차원 배열
    // - nodeinfo의 길이는 1 이상 10,000 이하
    // - nodeinfo[i]는 i + 1번 노드의 좌표이며, [x축 좌표, y축 좌표] 순으로 들어있음
    // - 모든 노드의 좌표값은 1 이상 100,000 이하인 자연수
    // - 트리의 깊이가 1,000 이하인 경우만 입력으로 주어짐
    // - 모든 노드의 x값과 y값은 각각 중복되지 않음
    // - 반환값은 [전위 순회 결과, 후위 순회 결과]

    public int[][] solution(int[][] nodeinfo) {
        // TODO: 풀이 작성
        return new int[0][];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex066_42892 s = new Ex066_42892();

        check(1, s.solution(new int[][]{
                {5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}}),
                new int[][]{{7, 4, 6, 9, 1, 8, 5, 2, 3}, {9, 6, 5, 8, 1, 4, 3, 2, 7}});
    }

    private static void check(int no, int[][] actual, int[][] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.deepEquals(actual, expected) ? "PASS" : "FAIL",
                Arrays.deepToString(expected), Arrays.deepToString(actual));
    }
}
