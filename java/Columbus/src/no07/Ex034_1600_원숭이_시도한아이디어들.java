package no07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex034_1600_원숭이_시도한아이디어들 {
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

        // 현재 코드로는 가지 못하는 길 (2, 1)을 갈 수 있는 길 (1, 2) 보다 먼저 선택하면서 K==0이 되어 버려서 갈 수 있는 길을 선택 못함
        // 즉, K--으로 돌리면 모든 가능햔 경우를 판별할 수 없음
        // K개 선택할 수 있는 경우는 재귀로 접근해야 하나? 사용했다가 안 했다가?

        // 그러면 처음부터 for문 2개를 같이 가지 말고, 우선 K가 다 떨어질 때까지 최대한 간 다음에
        // K==0이 되면 인접으로 접근해볼까?
        // 그리고 k--하는 위치도 매번이 아니야. 같은 층위는 같은 K이므로 for문 다 돌고나서 k--

        // 3%에서 틀림
        // 말로 먼저 접근하고 인접 사용하는 게 최단거리라는 보장이 안 될 것 같긴 했음..
        // 예를 들어 처음 자리에서 말 이동은 다 1이라서 못 가는 거야. 그러면 거기서 끝나버려
        // 실제로는 한 칸 인접으로 이동한 다음 말 이동해서 갈 수도 있는데 말이야..
        // 그러면 if 말이동 else 인접이동 이 아니라
        // 그냥 인접 이동도 가능하도록 ㄱㄱ

        // 여전히 3%에서 틀림
        // 아하! 장애물이 있어서 사용하지 않았을 때도 K가 줄어들게 돼

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

            if (K>0) {
                // 말의 이동
                for (int d=0; d<8; d++) {
                    int ny = y + d2y[d];
                    int nx = x + d2x[d];
                    if ( ny<0 || nx<0 || ny>=H || nx>=W || visited[ny][nx] || map[ny][nx]==1 ) continue;
                    q.add(new int[]{ny, nx});
                    map[ny][nx]= map[y][x]+1;
                    visited[ny][nx] = true;
                }
                K--;
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
