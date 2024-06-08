package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex026_14502_연구소_2차원대신1차원배열로관리해보자 {

    static int N, M, L;
    static int cnt1; // 입력에서 벽의 개수
    static ArrayList<int[][]> virus; // 입력에서 바이러스 위치 담기
    static int[][] map;
    static boolean[][] visited;
    static int k; // 조합 개수 (3이 될 때 멈출거야)
    static int test;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int max;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/14502

        // 안전영역이 이어져 있을 필요 없음!! (예제2번)

        // 시간 제한 2초, 메모리 제한 512M 로 엄청 넉넉하게 주어져 있는데
        // 3<=N,M<=8은 범위가 작게 주어진 거 보니까 완탐 맞나 봐

        // N*MC3으로 1 3개를 위치할 수 있는 모든 경우의 수 마다
            // 2를 퍼뜨리고
            // 0의 개수 세기 => max 갱신

        // N*MC3을 돌리기 위해 일차원 배열도 하나 만들자

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = N * M;

        map = new int[N][M];
        for (int y=0; y<N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x=0; x<M; x++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[y][x] = tmp;
                if (tmp==1) cnt1++; // 벽의 개수 미리 세기
                if (tmp==2) {
                    virus.add(new int[y][x]); // 바이러스 위치 담기
                }
            }
        }
//        // 잘 담겼는지 확인
//        for (int y=0; y<N; y++) {
//            for (int x=0; x<M; x++) {
//                System.out.print(map[y][x] + " ");
//            }
//            System.out.println();
//        }

        recur(0);

        // 조합 잘 도는지 확인
        System.out.println("test : " + test); // 6545 나오면 돼 OK

        System.out.println(max);

    }
    static void recur(int z) {
        // z >= L 이면 끝내기
        if (z >= L) return;

        // 벽 3개 모이면 바이러스 퍼뜨리기
        if (k==3) {
            // 조합 잘 도는지 확인
            test++;
//            // 여기서 bfs 사용해서 바이러스 퍼뜨리자
//            // 퍼뜨리면서 바이러스 갯수 세기
//            virus=cntV;
//            visited = new boolean[N][M];
//            // 각 바이러스들이 모두 진행
////            for ()
//            ArrayDeque<int[]> q = new ArrayDeque<>();
//            q.add(new int[]{z/M, z%M});
//            visited[z/M][z%M] = true;
//
//            while (!q.isEmpty()) {
//                int[] now = q.poll();
//                int nowY = now[0];
//                int nowX = now[1];
//                for (int d=0; d<4; d++) {
//                    int ny = nowY + dy[d];
//                    int nx = nowX + dx[d];
//                    if ( ny<0 || nx<0 || ny>=N || nx>=M || map[ny][nx]==1 || map[ny][nx]==2 || visited[ny][nx]) continue;
//                    else { // map[ny][nx]==0
//                        virus++;
//                        q.add(new int[]{ny, nx});
//                        visited[ny][nx] = true;
//                    }
//                }
//            }
//            // 전체 - 벽의 수 - 바이러스 수 = 0의 개수
//            max = Math.max(max, L-cnt1-3-virus);
            return;
        }

        // 해당 자리에 벽 세우기
            // 0일 때만 벽 세울 수 있어
            // 2나 1일 때는 그냥 다음 칸으로
        int y = z/M;
        int x = z%M;
        if (map[y][x]==0) {
            // 포함할 때
            map[y][x] = 1;
            k++;
            recur(z + 1);
            // 포함하지 않을 때
            // 해당 자리 원래 값인 0으로 돌리기
            map[y][x] = 0;
            k--;
            recur(z + 1);
        } else recur(z + 1);
    }

}
