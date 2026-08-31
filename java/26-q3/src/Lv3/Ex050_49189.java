package src.Lv3;

import java.util.*;

public class Ex050_49189 {

    // 문제: 가장 먼 노드
    // https://school.programmers.co.kr/learn/courses/30/lessons/49189
    // 키워드: BFS·그래프 이론 - 1번 노드에서 BFS를 돌려 최대 거리를 갖는 노드 수를 센다
    // 레벨: Lv.3 (그래프)
    //
    // 제한사항
    // - 노드의 개수 n은 2 이상 20,000 이하
    // - 간선은 양방향이며 총 1개 이상 50,000개 이하 존재
    // - vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미

    public int solution(int n, int[][] vertex) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex050_49189 s = new Ex050_49189();

        check(1, s.solution(6, new int[][]{
                {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}), 3);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
