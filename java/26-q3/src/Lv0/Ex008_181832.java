package src.Lv0;

import java.util.*;

public class Ex008_181832 {

    // 문제: 정수를 나선형으로 배치하기
    // https://school.programmers.co.kr/learn/courses/30/lessons/181832
    // 키워드: 시뮬레이션 - n*n 배열에 1부터 n^2까지 시계방향 나선형으로 채우기
    // 레벨: Lv.0 (코딩 기초 트레이닝)
    //
    // 제한사항
    // - 1 <= n <= 30

    public int[][] solution(int n) {
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int[][] answer = new int[n][n];
        int d = -1;
        int r = 0, c = 0, k = 1;
        answer[r][c]=k++;
        while(k<=n*n) {
            d = (d+1)%4; // 방향 전환
            while (true) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr<0 || nc<0 || nr>=n || nc>=n || answer[nr][nc]!=0) break;
                r = nr;
                c = nc;
                answer[r][c] = k++;
            }
        }
        return answer;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex008_181832 s = new Ex008_181832();

        check(1, s.solution(4), new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}});
        check(2, s.solution(5), new int[][]{
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}});
    }

    private static void check(int no, int[][] actual, int[][] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.deepEquals(actual, expected) ? "PASS" : "FAIL",
                Arrays.deepToString(expected), Arrays.deepToString(actual));
    }
}
