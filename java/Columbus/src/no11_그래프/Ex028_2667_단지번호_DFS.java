package no11_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Ex028_2667_단지번호_DFS {
    static int N;
    static boolean[][] map; // 0이면 false, 1이면 true
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int cnt;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2667

        // char 0은 아스키코드 48, 1은 아스키코드 49
//        char ch = '0';
//        System.out.println((int)ch);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new boolean[N][N];
        for (int y=0; y<N; y++) {
            String str = br.readLine();
            for (int x=0; x<N; x++) {
                map[y][x] = str.charAt(x)==49? true : false;
            }
        }

        visited = new boolean[N][N];
        ArrayList<Integer> list = new ArrayList<>(); // 카운트한 cnt 담기
        for (int y=0; y<N; y++) {
            for (int x=0; x<N; x++) {
                if (map[y][x] && !visited[y][x]) {
                    cnt = 0;
                    dfs(y, x);
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append('\n');
        list.forEach(e -> sb.append(e).append('\n'));

        System.out.println(sb);

    }
    static void dfs(int y, int x) {
        cnt++;
        visited[y][x] = true;

        for (int d=0; d<4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if ( nx<0 || ny<0 || nx>=N || ny>=N || !map[ny][nx] || visited[ny][nx] ) continue;
            dfs(ny, nx);
        }
    }
}
