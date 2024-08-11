package no11_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex032_2206_벽부수고이동_BFS {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2206

        // visited에서
            // 벽 안 부수고 이동 [0][][]
            // 벽 부수고 이동 [1][][]

        // 부순적이 있을 때 X 벽을 만나면 => 이동 불가
        // 부순적이 있을 때 X 길을 만나면 => 길로 이동 (isBreak 필드 true, visited[1])
        // 부순적이 없을 때 X 벽을 만나면 => 부수고 지나가기 (isBreak 필드 true, visited[1])
        // 부순적이 없을 때 X 길을 만나면 => 길로 이동 (isBreak 필드 false, visited[0])

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[2][N][M];
        for (int y=0; y<N; y++) {
            String str = br.readLine();
            for (int x=0; x<M; x++) {
                map[y][x] = Character.getNumericValue(str.charAt(x));
            }
        }

        System.out.println(bfs(0, 0));

    }
    static int bfs(int y, int x) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(false, y, x, 1));
        visited[0][y][x]=true;

        while(!q.isEmpty()) {
            Node now = q.poll();
            y = now.y;
            x = now.x;

            if (y==N-1 && x==M-1) return now.step;

            for (int d=0; d<4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if ( ny<0 || nx<0 || ny>=N || nx>=M ) continue;
                if (now.isBreak) { // 부순 적이 있다면?
                    if(!visited[1][ny][nx] && map[ny][nx]==0) { // (방문한 적 없는) 길로 이동 가능
                        q.add(new Node(true, ny, nx, now.step+1));
                        visited[1][ny][nx]=true;
                    }
                } else { // 부순 적이 없다면?
                    if (map[ny][nx]==1) {  // 벽이면 : 부수고 지나가기
                        q.add(new Node(true, ny, nx, now.step+1));
                        visited[1][ny][nx]=true;
                    } else if (!visited[0][ny][nx]){ // (방문한 적 없는) 길이면 : 그대로 길로 지나가기
                        q.add(new Node(false, ny, nx, now.step+1));
                        visited[0][ny][nx]=true;
                    }
                }
            }
        }
        return -1;
    }

    static class Node {
        boolean isBreak;
        int y;
        int x;
        int step;
        Node(boolean isBreak, int y, int x, int step) {
            this.isBreak = isBreak;
            this.y = y;
            this.x = x;
            this.step = step;
        }
    }
}

