package 선수문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex018_dxdy {

    // 삼각 달팽이 채우기
    // 아래 -> 오른쪽 -> 대각선 위
    static final int[] dx = {0, 1, -1};
    static final int[] dy = {1, 0, -1};

    public static void main(String[] args) throws IOException {
        // https://school.programmers.co.kr/learn/courses/30/lessons/68645

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n][n];
        // 값
        int v = 1;
        // 위치
        int x = 0;
        int y = 0;
        // 위치 변화량
        int d = 0;

        // 반복문을 돌면서 값을 채워나가자
        while (true){
            triangle[y][x] = v++;
            // next x, next y
            int nx = x + dx[d];
            int ny = y + dy[d];
            // 벽에 막히거나 이미 값을 채웠을 때는 방향 전환하기
            if ( nx==n || ny==n || nx==-1 || ny==-1 || triangle[ny][nx]!=0) {
                d = (d+1)%3;
                nx = x + dx[d];
                ny = y + dy[d];
                // 모두 숫자가 채워졌으면 전환된 방향으로도 더 이상 진행 못 해. => 끝
                if ( nx==n || ny==n || nx==-1 || ny==-1 || triangle[ny][nx]!=0) break;
            }
            // 새 방향으로 진도 나간다면 x, y 업데이터
            x = nx;
            y = ny;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            for (int j=0; j<=i; j++) {
                sb.append(triangle[i][j]).append('\t');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

}
