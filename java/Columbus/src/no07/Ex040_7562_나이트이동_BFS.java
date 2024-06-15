package no07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex040_7562_나이트이동_BFS {
    static int I;
    static int[][] map;
    static int goalY, goalX;
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/7562

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t=0; t<T; t++) {
            I = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int curY = Integer.parseInt(st.nextToken());
            int curX = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            goalY = Integer.parseInt(st.nextToken());
            goalX = Integer.parseInt(st.nextToken());

            map = new int[I][I];

            bfs(curY, curX);
            sb.append(map[goalY][goalX] - 1).append('\n');
        }
        System.out.println(sb);

    }
    static void bfs(int y, int x) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        map[y][x]= 1; // visited하지 않은 0과 비교하기 위해 1로 시작 (마지막에 -1)

        boolean isFind = false;
        while(!q.isEmpty() && !isFind){
            int[] now = q.poll();
            y = now[0];
            x = now[1];
            for (int d=0; d<8; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if ( ny<0 || nx<0 || ny>=I || nx>=I || map[ny][nx]>0 ) continue;
                q.add(new int[]{ny, nx});
                map[ny][nx] = map[y][x] + 1;
                // goal이면 끝
                if (goalY==ny && goalX==nx) {
                    isFind=true;
                    break;
                }
            }
        }
    }

}
