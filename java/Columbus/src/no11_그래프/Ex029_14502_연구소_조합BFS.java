package no11_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex029_14502_연구소_조합BFS {
    static int N, M, L;
    static int cntInitWall, cntWall, cntVirus;
    static ArrayList<int[]> virusList;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int max;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/14502

        // 벽 세우는 건 => nC3 조합 => 조합 재귀
        // 3개 채워지면 BFS로 바이러스 퍼뜨린 뒤 안전 영역 개수 구하기

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
                if (tmp==1) cntInitWall++; // 기존 벽의 개수
                if (tmp==2) virusList.add(new int[]{y, x});
            }
        }

//        // 잘 담겼는지 확인
//        for (int y=0; y<N; y++) {
//            for (int x=0; x<N; x++) {
//                System.out.print(map[y][x] + " ");
//            }
//            System.out.println();
//        }

        // z는 (0, 0)에서부터 (N-1, M-1)까지 나열한 것
        // z를 M으로 나눈 몫은 y, 나머지는 x => z/M=y, z%M=x
        recur(0);
        System.out.println(max);

    }

    static void recur(int z) {
        // 벽 3개 모이면 바이러스 퍼뜨리기
        if (cntWall==3) {
            cntVirus = virusList.size();
            // 초기화
            visited = new boolean[N][M];
            ArrayDeque<int[]> q = new ArrayDeque<>(virusList);
            for (int[] virus : virusList) {
                visited[virus[0]][virus[1]] = true;
            }
            // BFS 돌려서 바이러스 퍼뜨리기
            while (!q.isEmpty()) {
                int[] now = q.poll();
                int nowY = now[0];
                int nowX = now[1];
                for (int d=0; d<4; d++) {
                    int ny = nowY + dy[d];
                    int nx = nowX + dx[d];
                    if ( ny<0 || nx<0 || ny>=N || nx>=M || map[ny][nx]!=0 || visited[ny][nx]) continue;
                    cntVirus++;
                    q.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
            // 전체 - 벽의 수 - 바이러스 수 = 안전 영역의 개수
            max = Math.max(max, L-cntInitWall-3-cntVirus);
            return;
        }

        if (z >= L) return;

        // 재귀
        int y = z/M;
        int x = z%M;
        // 0이면 벽 세우고, 아니면 다음 z로 이동
        if (map[y][x]==0) {
            // 벽 세우는 경우
            map[y][x]=1;
            cntWall++;
            recur(z+1);
            // 벽 세우지 않는 경우
            map[y][x]=0;
            cntWall--;
            recur(z+1);
        } else recur(z+1);
    }
}
