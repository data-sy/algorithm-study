package no10_재귀브루트포싱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex025_1743_음식물_BFS {
    static int N, M;
    static boolean[][] map;
    static boolean[][] visited;
    static int cnt;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1743

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]=true;
        }

        visited = new boolean[N][M];
        int max = -1;
        for (int r=0; r<N; r++) {
            for (int c=0; c<M; c++) {
                if (!visited[r][c] && map[r][c]) {
                    cnt=0;
                    bfs(r, c);
                    max = Math.max(max, cnt);
                }
            }
        }
        System.out.println(max);
    }
    static void bfs(int r, int c) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});
        visited[r][c]= true;
        cnt++;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            r = now[0];
            c = now[1];
            for (int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if ( nr<0 || nc<0 || nr>=N || nc>=M || visited[nr][nc] || !map[nr][nc]) continue;
                q.add(new int[]{nr, nc});
                visited[nr][nc]=true;
                cnt++;
            }
        }
    }

}
