package no07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex036_2206_벽부수기_BFS_시간초과 {
    static int N, M;
    static int[][] wallMap;
    static int[][] stepMap;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2206

        // 벽의 개수만큼 반복문을 돌리면서 bfs를 돌리는 건 시간초과인가봐..

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        wallMap = new int[N][M];
        stepMap = new int[N][M];
        for (int y=0; y<N; y++) {
            String str = br.readLine();
            for (int x=0; x<M; x++) {
                int tmp = Character.getNumericValue(str.charAt(x));
                // 0은 기본값으로 들어있으니 1일 때만 처리하면 돼
                if (tmp==1) {
                    wallMap[y][x] = tmp;
                    stepMap[y][x] = tmp;
                }
            }
        }

        int min = 1000001;
        for (int y=0; y<N; y++) {
            for (int x=0; x<M; x++) {
                if (wallMap[y][x]==1) {
                    visited = new boolean[N][M];
                    stepMap[N-1][M-1]=0;
                    wallMap[y][x]=0;
                    bfs(0, 0);
                    if (stepMap[N-1][M-1]!=0) min = Math.min(min, stepMap[N-1][M-1]);
                    wallMap[y][x]=1;
                }
            }
        }
        System.out.println(min==1000001 ? -1 : min);

    }
    static void bfs(int y, int x) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        stepMap[y][x]=1;
        visited[y][x]=true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            y = now[0];
            x = now[1];
            for (int d=0; d<4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if ( ny<0 || nx<0 || ny>=N || nx>=M || visited[ny][nx] || wallMap[ny][nx]==1) continue;
                q.add(new int[]{ny, nx});
                stepMap[ny][nx]=stepMap[y][x]+1;
                visited[ny][nx]=true;
            }
        }

    }

}
