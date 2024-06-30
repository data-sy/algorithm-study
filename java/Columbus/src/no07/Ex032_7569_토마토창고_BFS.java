package no07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex032_7569_토마토창고_BFS {
    static int M, N, H;
    static int[][][] tomatoBox;
    static ArrayDeque<int[]> q;
    static boolean[][][] visited;
    static int[] dx = {0, 0, -1, 1, 0, 0}; // 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
    static int[] dy = {0, 0, 0, 0, 1, -1};
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int cntVisited;
    static int lastDay;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/7569

        // E020_7576_토마토 문제의 3차원 버전

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        int L = H * N * M;

        tomatoBox = new int[H][N][M];
        visited = new boolean[H][N][M];
        q = new ArrayDeque<>();
        for (int z=0; z<H; z++) {
            for (int y=0; y<N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x=0; x<M; x++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    tomatoBox[z][y][x] = tmp;
                    if (tmp!=0) { // 즉, 1과 -1일 때
                        visited[z][y][x] = true;
                        cntVisited++;
                        if (tmp==1) q.add(new int[]{z, y, x});
                    }
                }
            }
        }
//        // 잘 담겼는지 확인
//        for (int z=0; z<H; z++) {
//            for (int y=0; y<N; y++) {
//                for (int x=0; x<M; x++) {
//                    System.out.print(tomatoBox[z][y][x] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("=================");
//        }

        // 모두 익어있는 상태 : 전체 = cntVisited
        if (cntVisited==L) System.out.println(0);
        else {
            // BFS 돌려서 최단 거리 기록
            while (!q.isEmpty()) {
                int[] now = q.poll();
                int z = now[0];
                int y = now[1];
                int x = now[2];
                for (int d=0; d<6; d++) {
                    int nz = z + dz [d];
                    int ny = y + dy[d];
                    int nx = x + dx[d];
                    if ( nz<0 || ny<0 || nx<0 || nz>=H || ny>=N || nx>=M || visited[nz][ny][nx]) continue;
                    q.add(new int[]{nz, ny, nx});
                    visited[nz][ny][nx] = true;
                    cntVisited++;
                    tomatoBox[nz][ny][nx] = tomatoBox[z][y][x]+1;
                    // 마지막에 담긴 lastDay가 최단거리
                    lastDay = tomatoBox[z][y][x];
                }
            }
//            // 잘 담겼는지 확인
//            for (int z=0; z<H; z++) {
//                for (int y=0; y<N; y++) {
//                    for (int x=0; x<M; x++) {
//                        System.out.print(tomatoBox[z][y][x] + " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println("=================");
//            }
            // 방문하지 못한 0이 존재 :  cntVisited < 전체
            System.out.println( cntVisited<L ? -1 : lastDay);
        }
    }
}
