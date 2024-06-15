package no07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex034_1600_원숭이_BFS_실패 {
    static int K, W, H;
    static int[][] map;
    static boolean[][] visited;
    static int[] d1x = {0, 0, -1, 1};
    static int[] d1y = {-1, 1, 0, 0};
    static int[] d2x = {-1, -2, 1, 2, -1, -2, 1, 2}; // 말의 이동
    static int[] d2y = {-2, -1, -2, -1, 2, 1, 2, 1};
    static int result;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1600

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for (int y=0; y<H; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x=0; x<W; x++) {
                map[y][x] =Integer.parseInt(st.nextToken());
            }
        }
//        // 잘 들어갔는지 확인
//        for (int y=0; y<H; y++) {
//            for (int x=0; x<W; x++) {
//                System.out.print(map[y][x]);
//            }
//            System.out.println();
//        }
        visited = new boolean[H][W];
        result = -1;
        bfs(0, 0);
        System.out.println(result);

    }
    static void bfs(int y, int x) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        visited[y][x]=true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            y = now[0];
            x = now[1];

            // 해당 위치에 딱 도달한다면
            if (y==H-1 && x==W-1) {
                result = map[y][x];
                return;
            }

            // 말의 이동
            for (int d=0; d<8; d++) {
                int ny = y + d2y[d];
                int nx = x + d2x[d];
                if ( ny<0 || nx<0 || ny>=H || nx>=W || visited[ny][nx] || map[ny][nx]==1 ) continue;
                q.add(new int[]{ny, nx});
                map[ny][nx]= map[y][x]+1;
                visited[ny][nx] = true;
            }
            // 인접 이동
            for (int d=0; d<4; d++) {
                int ny = y + d1y[d];
                int nx = x + d1x[d];
                if ( ny<0 || nx<0 || ny>=H || nx>=W || visited[ny][nx] || map[ny][nx]==1 ) continue;
                q.add(new int[]{ny, nx});
                map[ny][nx]= map[y][x]+1;
                visited[ny][nx] = true;
            }
        }

    }

}
