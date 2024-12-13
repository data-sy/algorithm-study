package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Ex025_2667_단지번호_DFS {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};
    static int cnt;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2667

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] map = new int[3][3];
        map[0].length;

        map = new int[N][N];
        for (int y=0; y<N; y++) {
            String str = br.readLine();
            for (int x=0; x<N; x++) {
                map[y][x] = Character.getNumericValue(str.charAt(x));
            }
        }

//        // 잘 담겼는지 확인
//        for (int y=0; y<N; y++) {
//            for (int x=0; x<N; x++) {
//                System.out.print(map[y][x] + " ");
//            }
//            System.out.println();
//        }

        visited = new boolean[N][N];
        ArrayList<Integer> list = new ArrayList<>(); // 단지 별 집의 수 담을 리스트
        for (int y=0; y<N; y++) {
            for (int x=0; x<N; x++) {
                if (map[y][x]==1 && !visited[y][x]) {
                    cnt = 0;
                    dfs(y, x);
                    list.add(cnt);
                }
            }
        }
        System.out.println();

        sb.append(list.size()).append('\n');
        Collections.sort(list);
        list.forEach(e -> sb.append(e).append('\n'));
        System.out.println(sb);

    }
    static void dfs(int y, int x) {
        cnt++;
        visited[y][x] = true;

        for (int d=0; d<4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if ( nx<0 || ny<0 || nx>=N || ny>=N || map[ny][nx]==0 || visited[ny][nx] ) continue;
            dfs(ny, nx);
        }
    }
}
