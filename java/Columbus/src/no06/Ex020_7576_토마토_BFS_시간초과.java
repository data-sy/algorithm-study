package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex020_7576_토마토_BFS_시간초과 {
    static int N, M;
    static int[][] tomatoBox;
    static boolean[][] visited;
    static final int[] dx = {0, 0, -1, 1}; // 상, 하, 좌, 우
    static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/7565

        // 토마토 박스에 bfs를 돌면서 step을 갱신해서 박스에 step을 채우고
        // 거기서 max를 찾아서 선택!
        // 이대로는 시간 초과가 남

        // 개선할 부분들 찾아보자!
        // 토마토 1인 것들 미리 list에 받아서 이걸 반복문으로 돌렸을 때도 시간초과

        // 결국 전체적인 풀이 자체가 시간복잡도를 넘기나봐. 다른 방법을 고안 해 내야 해

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int cnt0 = 0;
        tomatoBox = new int[N][M];
        for (int y=0; y<N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x=0; x<M; x++) {
                int tmp = Integer.parseInt(st.nextToken());
                tomatoBox[y][x] = tmp;
                if (cnt0==0 && tmp==0) cnt0++;
            }
        }
//        // 잘 담겼는지 확인
//        for (int y=0; y<N; y++) {
//            for (int x=0; x<M; x++) {
//                System.out.print(tomatoBox[y][x] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println(cnt0);

        if (cnt0==0) System.out.println(0); // 모든 토마토가 익어있는 상태
        else {
            // bfs 돌리기 & tomatoBox에 step 갱신
            for (int y=0; y<N; y++) {
                for (int x=0; x<M; x++) {
                    if (tomatoBox[y][x]==1) {
                        // 각 bfs마다 새로운 visited로 갱신해야 하니까 초기화를 여기서
                        visited = new boolean[N][M];
                        bfs(y, x);
                    }
                }
            }
//             // 잘 담겼는지 확인
//            for (int y=0; y<N; y++) {
//                for (int x=0; x<M; x++) {
//                    System.out.print(tomatoBox[y][x] + " ");
//                }
//                System.out.println();
//            }

            boolean hasZero = false;
            int max = 0;
            for (int y=0; y<N; y++) {
                for (int x=0; x<M; x++) {
                    int step = tomatoBox[y][x];
                    if (step==0) {
                        hasZero = true;
                        break;
                    }
                    if (max<step) max=step;
                } if (hasZero) break;
            }
            System.out.println(hasZero ? -1 : max-1);
        }

    }
    static void bfs(int y, int x) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {y, x});
        visited[y][x] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            y = now[0];
            x = now[1];
            for (int d=0; d<4; d++) {
                int ny = now[0] + dy[d];
                int nx = now[1] + dx[d];
                // 범위를 벗어나거나, -1이거나, 1이거나, 방문한 적이 있을 때는 continue
                if ( nx<0 || ny<0 || nx>=M || ny>=N || tomatoBox[ny][nx]==-1 || tomatoBox[ny][nx]==1 || visited[ny][nx] ) continue;
                q.add(new int[] {ny, nx});
                if (tomatoBox[ny][nx]==0) tomatoBox[ny][nx]=tomatoBox[y][x]+1; // 0 일 때는 갱신하고
                else tomatoBox[ny][nx]=Math.min(tomatoBox[y][x]+1, tomatoBox[ny][nx]); // 0보다 클 때는 한 번 값이 들어갔던 애니까 min으로 처리
                visited[ny][nx]=true;
            }
        }
    }

}
