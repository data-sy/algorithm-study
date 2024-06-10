package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex027_14940_최단거리_BFS {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/14940

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        int targetY = 0;
        int targetX = 0;
        for (int y=0; y<n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x=0; x<m; x++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[y][x] = tmp;
                if (tmp==2) {
                    targetY = y;
                    targetX = x;
                }
            }
        }

        visited = new boolean[n][m];
        bfs(targetY, targetX);

//        // 잘 들어갔나 확인
//        for (int y=0; y<n; y++) {
//            for (int x=0; x<m; x++) {
//                System.out.print(map[y][x] + "\t"); //'\t'로 넣으니 +9를 한 숫자가 나와 왜일까??
//            }
//            System.out.println();
//        }

        StringBuilder sb = new StringBuilder();
        for (int y=0; y<n; y++) {
            for (int x=0; x<m; x++) {
                if (map[y][x]==0) sb.append(0).append(' ');
                else if (visited[y][x]) sb.append(map[y][x]).append(' ');
                else sb.append(-1).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }
    static void bfs(int y, int x) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        map[y][x]=0;
        visited[y][x] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            y = now[0];
            x = now[1];
            for (int d=0; d<4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if ( ny<0 || nx< 0 || ny>=n || nx>=m || visited[ny][nx] || map[ny][nx]==0 ) continue;
                q.add(new int[]{ny, nx});
                map[ny][nx] =  map[y][x]+1;
                visited[ny][nx] = true;
            }
        }
    }

}
