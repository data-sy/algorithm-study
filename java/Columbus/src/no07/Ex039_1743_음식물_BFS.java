package no07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex039_1743_음식물_BFS {
    static int N, M;
    static boolean[][] map;
    static boolean[][] visited;
    static int cnt;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

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
        for (int y=0; y<N; y++) {
            for (int x=0; x<M; x++) {
                if (!visited[y][x] && map[y][x]) {
                    cnt=0;
                    bfs(y, x);
                    if (max<cnt) max = cnt;
                }
            }
        }
        System.out.println(max);

    }
    static void bfs(int y, int x) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        visited[y][x]= true;
        cnt++;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            y = now[0];
            x = now[1];
            for (int d=0; d<4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if ( ny<0 || nx<0 || ny>=N || nx>=M || visited[ny][nx] || !map[ny][nx]) continue;
                q.add(new int[]{ny, nx});
                visited[ny][nx]=true;
                cnt++;
            }

        }

    }

}
