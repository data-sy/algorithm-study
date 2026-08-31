package src.Lv3;

import java.util.*;

public class Ex055_84021 {

    // 문제: 퍼즐 조각 채우기
    // https://school.programmers.co.kr/learn/courses/30/lessons/84021
    // 키워드: BFS·구현 - 빈칸 덩어리와 조각 덩어리를 뽑아 회전 4방향으로 맞춰본다
    // 레벨: Lv.3 (2021 KAKAO BLIND RECRUITMENT)
    //
    // 제한사항
    // - 3 <= game_board의 행 길이 <= 50
    // - game_board의 각 열 길이 = game_board의 행 길이 (정사각 격자)
    // - game_board의 모든 원소는 0 또는 1 (0은 빈칸, 1은 이미 채워진 칸)
    // - 빈칸은 1 x 1 크기부터 최대 6개까지 연결된 형태로만 주어짐
    // - table의 행/열 길이는 game_board와 같고, 모든 원소는 0 또는 1
    //   (0은 빈칸, 1은 조각이 놓인 칸)
    // - 퍼즐 조각은 1 x 1 크기부터 최대 6개까지 연결된 형태로만 주어짐
    // - game_board에는 반드시 하나 이상의 빈칸이 있음
    // - table에는 반드시 하나 이상의 블록이 놓여 있음

    public int solution(int[][] game_board, int[][] table) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex055_84021 s = new Ex055_84021();

        check(1, s.solution(new int[][]{
                {1, 1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 0, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 0}}, new int[][]{
                {1, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1, 1},
                {0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 0}}), 14);
        check(2, s.solution(new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 1}}, new int[][]{
                {1, 1, 1},
                {1, 0, 0},
                {0, 0, 0}}), 0);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
