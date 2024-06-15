package no07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex036_2206_벽부수기_clone_시간초과 {
    static int N, M;
    static int[][] map, cloneMap;
    static ArrayList<int[]> wallList;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2206

        // 맵을 clone해서 사용하는 방법은 시간초과

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        wallList = new ArrayList<>();
        for (int y=0; y<N; y++) {
            String str = br.readLine();
            for (int x=0; x<M; x++) {
                int tmp = Character.getNumericValue(str.charAt(x));
                map[y][x] = tmp;
                if (tmp==1) wallList.add(new int[]{y, x});
            }
        }

        cloneMap = new int[N][M];
        int min = 1000001;
        for ( int[] wall : wallList ) {
            // 맵을 클론해서 사용해보자.
            for (int i = 0; i < N; i++) cloneMap[i] = map[i].clone();
            cloneMap[wall[0]][wall[1]] = 0;
            bfs(0, 0);
            if (cloneMap[N - 1][M - 1]!=0) min = Math.min(min, cloneMap[N - 1][M - 1]);
        }
        System.out.println(min==1000001 ? -1 : min);

    }
    static void bfs(int y, int x) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        cloneMap[y][x]=1;

        while(!q.isEmpty()){
            int[] now = q.poll();
            y = now[0];
            x = now[1];
            for (int d=0; d<4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];                   // 이걸로 visited까지 처리
                if ( ny<0 || nx<0 || ny>=N || nx>=M || cloneMap[ny][nx]>=1) continue;
                q.add(new int[]{ny, nx});
                cloneMap[ny][nx]=cloneMap[y][x]+1;
            }
        }

    }

}
