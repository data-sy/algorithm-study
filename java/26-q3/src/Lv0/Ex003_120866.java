package src.Lv0;

import java.util.*;

public class Ex003_120866 {

    // 문제: 안전지대
    // https://school.programmers.co.kr/learn/courses/30/lessons/120866
    // 키워드: 2차원 배열 - 지뢰(1)의 8방향 인접 칸을 위험지역으로 칠하고 남은 칸 세기
    // 레벨: Lv.0 (코딩테스트 입문)
    //
    // 제한사항
    // - board는 n * n 배열
    // - 1 <= n <= 100
    // - board에는 지뢰가 있는 지역 1과 지뢰가 없는 지역 0만 존재

    static int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};

    public int solution(int[][] board) {
        int answer = 0;
        int n = board[0].length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j]==1) {
                    for (int k=0; k<x.length; k++) {
                        int dx = i + x[k];
                        int dy = j + y[k];
                        if ( dx<0 || n<=dx || dy<0 || n<=dy ) continue;
                        if (board[dx][dy]==0) board[dx][dy]=2;
                    }
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j]==0) answer++;
            }
        }
        return answer;
    }

    // 느낀 점
    // 변화량 변수명을 x, y가 아니라 dx, dy로 하는 게 관례임 (나는 반대로 사용함;;)
    //   static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}; // 방향 변화량 -> dx, dy
    //   static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    //   int nx = i + dx[k]; // 이동 후 좌표 -> nx, ny (next)
    //   int ny = j + dy[k];
    // 혹은 x, y(축)이 아니라 r(행), c(열)이 더 선호됨
    //   static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1}; // delta row
    //   static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1}; // delta col

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex003_120866 s = new Ex003_120866();

        check(1, s.solution(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}}), 16);
        check(2, s.solution(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0}}), 13);
        check(3, s.solution(new int[][]{
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}}), 0);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%d  내결과=%d%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
