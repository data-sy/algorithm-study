package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex026_14502_연구소_조합BFS {

    static int N, M, L;
    static int cnt1; // 입력에서 벽의 개수
    static ArrayList<int[]> virusList; // 입력에서 바이러스 위치 담기
    static int[][] map;
    static boolean[][] visited;
    static int k; // 조합 개수 (3이 될 때 멈출거야)
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int cntVirus;
    static int max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = N * M;

        map = new int[N][M];
        virusList = new ArrayList<>();
        for (int y=0; y<N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x=0; x<M; x++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[y][x] = tmp;
                if (tmp==1) cnt1++; // 벽의 개수 미리 세기
                if (tmp==2) virusList.add(new int[]{y, x}); // 바이러스 위치 담기
            }
        }
        recur(0);
        System.out.println(max);

    }
    static void recur(int z) {
        // 벽 3개 모이면 바이러스 퍼뜨리기
        if (k==3) {
            // 여기서 bfs 사용해서 바이러스 퍼뜨리자 (+ 바이러스 개수 세기)
            visited = new boolean[N][M];
            cntVirus = virusList.size();
            for (int[] start : virusList) {
                ArrayDeque<int[]> q = new ArrayDeque<>();
                q.add(new int[]{start[0], start[1]});
                visited[start[0]][start[1]] = true;

                while (!q.isEmpty()) {
                    int[] now = q.poll();
                    int nowY = now[0];
                    int nowX = now[1];
                    for (int d=0; d<4; d++) {
                        int ny = nowY + dy[d];
                        int nx = nowX + dx[d];
                        if ( ny<0 || nx<0 || ny>=N || nx>=M || map[ny][nx]==1 || map[ny][nx]==2 || visited[ny][nx]) continue;
                        else { // map[ny][nx]==0
                            cntVirus++;
                            q.add(new int[]{ny, nx});
                            visited[ny][nx] = true;
                        }
                    }
                }
            }
            // 전체 - 벽의 수 - 바이러스 수 = 0의 개수
            max = Math.max(max, L-cnt1-3-cntVirus);
            return;
        }

        // z >= L 이면 끝내기
        if (z >= L) return;

        // 해당 자리에 벽 세우기
        int y = z/M;
        int x = z%M;
        if (map[y][x]==0) { // 0일 때 벽 세우기
            // 그 자리에 벽 세울 때
            map[y][x] = 1;
            k++;
            recur(z + 1);
            // 그 자리에 벽 안 세울 때 (해당 자리 원래 값인 0으로 돌리기)
            map[y][x] = 0;
            k--;
            recur(z + 1);
        } else recur(z + 1);
    }

}
