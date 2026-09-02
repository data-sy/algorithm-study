package src.set07;

import java.util.*;

public class Ex063_1844 {

    // 문제: 게임 맵 최단거리
    // https://school.programmers.co.kr/learn/courses/30/lessons/1844
    // 키워드: BFS·최단 거리 - 좌측 상단에서 우측 하단까지 지나간 칸 수의 최솟값
    // 레벨: Lv.2 (깊이/너비 우선 탐색(DFS/BFS))
    //
    // 제한사항
    // - maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로,
    //   n과 m은 각각 1 이상 100 이하의 자연수
    // - n과 m은 서로 같을 수도, 다를 수도 있지만 n과 m이 모두 1인 경우는 입력으로 주어지지 않음
    // - maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리
    // - 처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며,
    //   상대 팀 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있음
    // - 상대 팀 진영에 도착할 수 없을 때는 -1을 return

    public int solution(int[][] maps) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex063_1844 s = new Ex063_1844();

        check(1, s.solution(new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}}), 11);
        check(2, s.solution(new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}}), -1);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
