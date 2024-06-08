package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex018_1012_배추_DFS {

    static int M;
    static int N;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};
    static int[][] baechubat;
    static boolean[][] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1012

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 초기화
            baechubat = new int[N][M];
            visited = new boolean[N][M];
            for (int j=0; j<K; j++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                baechubat[B][A] = 1;
            }

            // dfs 돌리기
            cnt = 0;
            for (int x=0; x<M; x++) {
                for (int y=0; y<N; y++) {
                    if (baechubat[y][x]==1 && !visited[y][x]) {
                        cnt++;
                        dfs(y, x);
                    }
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
    static void dfs (int y, int x) {
        visited[y][x] = true;

        for (int d=0; d<4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            // 범위를 벗어나거나 (먼저 해줘야 인덱스에러 안 남) 배추가 0이거나 방문한 적이 있으면 컨티뉴
            if ( nx<0 || ny<0 || nx>=M || ny>=N || baechubat[ny][nx]==0 || visited[ny][nx] ) continue;
            dfs(ny, nx);
        }

    }

}
