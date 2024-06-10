package 다시풀기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex018_1012_배추o {

    static int N, M;
    static boolean[][] baechubat; // 1은 true, 0은 false
    static ArrayList<int[]> baechuList;
    static boolean[][] visited;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1012

        // 기존 코드와 달라진 점은
        // 1 : 배추밭을 불리언 배열로 0. 1 만 담도록
        // 2 : 기존에 전체 밭을 이중포문으로 돌던 걸, 1인 배추를 리스트에 담아서 리스트의 포문 돌리기

        // 둘 다 성능 개선되라고 한 거였는데, 오히려 성능 떨어지네?!

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            baechubat = new boolean[N][M];
            baechuList = new ArrayList<>();
            for (int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                baechubat[B][A] = true;
                baechuList.add(new int[]{B, A});
            }

            int cnt = 0;
            visited = new boolean[N][M];
            for (int[] baechu : baechuList) {
                if (!visited[baechu[0]][baechu[1]]) {
                    cnt++;
                    bfs(baechu[0], baechu[1]);
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
    static void bfs(int y, int x) {
        visited[y][x] = true;

        for (int d=0; d<4; d++) {
            int ny = y+dy[d];
            int nx = x+dx[d];
            if ( nx<0 || ny<0 || nx>=M || ny>=N || !baechubat[ny][nx] || visited[ny][nx]) continue;
            visited[ny][nx] = true;
            bfs(ny, nx);
        }

    }

}
