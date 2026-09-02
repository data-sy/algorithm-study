package src.set06;

import java.util.*;

public class Ex059_67259 {

    // 문제: 경주로 건설
    // https://school.programmers.co.kr/learn/courses/30/lessons/67259
    // 키워드: BFS·그래프 이론 - 직선 100원 / 코너 500원. 방향까지 상태에 넣어야 한다
    // 레벨: Lv.3 (2020 카카오 인턴십)
    //
    // 제한사항
    // - board는 2차원 정사각 배열로 배열의 크기는 3 이상 25 이하
    // - board 배열의 각 원소의 값은 0 또는 1 (0은 비어있음, 1은 벽)
    // - 도면의 가장 왼쪽 상단 좌표는 (0, 0), 가장 우측 하단 좌표는 (N-1, N-1)
    // - 출발점과 도착점 칸의 원소의 값은 항상 0
    // - board는 항상 출발점에서 도착점까지 경주로를 건설할 수 있는 형태

    public int solution(int[][] board) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex059_67259 s = new Ex059_67259();

        check(1, s.solution(new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}}), 900);
        check(2, s.solution(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}}), 3800);
        check(3, s.solution(new int[][]{
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 1, 0, 1},
                {1, 0, 0, 0}}), 2100);
        check(4, s.solution(new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0},
                {0, 0, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}}), 3200);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
