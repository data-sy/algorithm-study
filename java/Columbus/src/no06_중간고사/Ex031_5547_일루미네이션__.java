package no06_중간고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex031_5547_일루미네이션__ {
    static int W, H;
    static int map[][];
    static boolean visited[][];
    static int[] dxEven = {0, 1, 1}; // 하, 우하, 우
    static int[] dxOdd = {0, -1, 1}; // 하, 좌하, 우
    static int[] dy = {1, 1, 0}; // // 하, 우(좌)하, 우
    static int nx;
    static int cntNode;
    static int cntEdge;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/5547

        // y가 짝수일 때는 오른쪽 아래가 인접
        // 홀수일 때는 왼쪽 아래가 인접

        // 필요한 것
            // 각 구역마다 1의 개수 세고, 간선 개수 세기

        // 그러면 내부는 어떻게 처리할 수 있을까?

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

        visited = new boolean[H][W];
//        for (int y=0; y<H; y++) {
//            for (int x=0; x<W; x++) {
//                if (!visited[y][x]) {
//                    if (map[y][x]==1) {
//                        cntNode = 0;
//                        cntEdge = 0;
//                        bfs1(y, x);
//                    } else { // 0일 때
//
//                    }
//                }
//            }
//        }
        bfs1(0, 1);
        System.out.println(cntNode);
        System.out.println(cntEdge);

    }
    static void bfs1(int y, int x) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            y = now[0];
            x = now[1];
            for (int d = 0; d < 3; d++) {
                if (y % 2 == 0) nx = x + dxEven[d];
                else nx = x + dxOdd[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
                if (map[ny][nx]==1) cntEdge++;
                if (visited[ny][nx]) continue;
                cntNode++;
                q.add(new int[]{y, x});
            }
        }

    }

}
