package no11_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex032_1600_원숭이말_BFS {
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;
    static int[] d1x = {0, 0, -1, 1};
    static int[] d1y = {-1, 1, 0, 0};
    static int[] d2x = {-1, -2, 1, 2, -1, -2, 1, 2}; // 말의 이동
    static int[] d2y = {-2, -1, -2, -1, 2, 1, 2, 1};

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1600

        // 또 못 풀어서 저번 풀이 참고 ㅜㅠ
            // k개 소모할 때 까지는 말의 이동 => visited를 한 차원 높여서 관
            // 같은 위치를 지나가도 k가 다를 수 있어 => 다른 노드로 처리해야 하므로 => 노드 클래스 만들어서 관리

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

        visited = new boolean[K+1][H][W];
        System.out.println(bfs(0, 0));

    }
    static int bfs(int y, int x) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 0, 0));
        visited[0][y][x]=true;

        while(!q.isEmpty()) {
            Node now = q.poll();
            y = now.y;
            x = now.x;

            // 해당 위치에 딱 도달한다면
            if (y==H-1 && x==W-1) return now.step;

            // 상하좌우 인접
            for (int d=0; d<4; d++) {
                int ny = y + d1y[d];
                int nx = x + d1x[d];
                if ( ny<0 || nx<0 || ny>=H || nx>=W || visited[now.k][ny][nx] || map[ny][nx]==1 ) continue;
                q.add(new Node(now.k, ny, nx, now.step+1));
                visited[now.k][ny][nx] = true;
            }
            if (now.k<K) { // 아직 K에 도달하지 않았다면 - 말로도 이동
                // 말의 이동
                for (int d=0; d<8; d++) {
                    int ny = y + d2y[d];
                    int nx = x + d2x[d];
                    if ( ny<0 || nx<0 || ny>=H || nx>=W || visited[now.k+1][ny][nx] || map[ny][nx]==1 ) continue;
                    q.add(new Node(now.k+1, ny, nx, now.step+1));
                    visited[now.k+1][ny][nx] = true;
                }
            }
        }
        return -1;
    }

    static class Node {
        int k;
        int y;
        int x;
        int step;
        Node (int k, int y, int x, int step) {
            this.k = k;
            this.y = y;
            this.x = x;
            this.step = step;
        }
    }

}

