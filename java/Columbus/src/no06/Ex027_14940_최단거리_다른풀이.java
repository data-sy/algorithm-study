package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex027_14940_최단거리_다른풀이 {
    static int n, m;
    static Loc goal;
    static int[][] map;
    static boolean[][] visited;
    static ArrayDeque<Loc> q;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/14940

        // 콜롬버스스터디 - 중반 - 유진님 풀이

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) goal = new Loc(i, j); // 2는 골
                else if (num == 0) map[i][j] = -1; // 갈 수 없는 땅인 0은 -1을 넣어주고
                else map[i][j] = -2; // 갈 수 있는 땅인 1은 -2를 넣어주자.
            }
        }

        q = new ArrayDeque<>();
        visited = new boolean[n][m];
        bfs(goal);

//        // 잘 들어갔나 확인
//        for (int y=0; y<n; y++) {
//            for (int x=0; x<m; x++) {
//                System.out.print(map[y][x] + "\t"); //'\t'로 넣으니 +9를 한 숫자가 나와 왜일까??
//            }
//            System.out.println();
//        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1) sb.append("0 ");
                else if (map[i][j] == -2) sb.append("-1 ");
                else sb.append(map[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());

    }
    static class Loc {
        int x, y;
        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static void bfs(Loc loc) {
        q.add(goal);
        visited[goal.x][goal.y] = true;
        int len = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Loc now = q.poll();
                map[now.x][now.y] = len;
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dir[i][0], ny = now.y + dir[i][1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (!visited[nx][ny] && map[nx][ny] != -1) {
                            visited[nx][ny] = true;
                            q.add(new Loc(nx, ny));
                        }
                    }
                }
            }
            len++;
        }
    }

}
