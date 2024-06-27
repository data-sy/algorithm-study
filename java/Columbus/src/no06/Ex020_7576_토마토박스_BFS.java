package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex020_7576_토마토박스_BFS {
    static int N, M;
    static int[][] tomatoBox;
    static boolean[][] visited;
    static int cntVisited;
    static ArrayDeque<int[]> q;
    static final int[] dx = {0, 0, -1, 1}; // 상, 하, 좌, 우
    static final int[] dy = {-1, 1, 0, 0};
    static int lastDay;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/7565

        // 토마토 마다 각자 BFS를 돌리는 게 아니라 익은 자리를 한번에 큐에 담고 BFS를 돌리면
            // 각각 가까운 거리만큼씩 나눠서 움직이게 돼
            // 제일 처음 도달한 거리가 최단거리 이므로 visited에도 문제 없어
        // => 입력 받을 때 1인 것은 큐에 담기

        // 토마토가 모두 익지는 못하는 경우도 직접 돌아가지 말고 개수를 미리 세자
        // 뱅문한 토마토 개수 + -1의 개수 (토마토가 들어있지 않은 위치 개수 ) 가 전체 개수가 되어야 모두 익은 것

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int cnt0 = 0;
        int cntNone = 0;
        tomatoBox = new int[N][M];
        visited = new boolean[N][M];
        q = new ArrayDeque<>();
        for (int y=0; y<N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x=0; x<M; x++) {
                int tmp = Integer.parseInt(st.nextToken());
                tomatoBox[y][x] = tmp;
                if (tmp==1) {
                    q.add(new int[]{y, x});
                    visited[y][x]=true;
                    cntVisited++;
                } else if (tmp==-1) cntNone++;
                else if (cnt0==0) cnt0++; // else를 통해 tmp==0일 때, cnt0까지 0이면 ++해주기 (0 하나라도 있으면 ++ 하고 끝)
            }
        }

        if (cnt0==0) System.out.println(0); // 모든 토마토가 익어있는 상태
        else {
            bfs();

//             // 잘 담겼는지 확인
//            for (int y=0; y<N; y++) {
//                for (int x=0; x<M; x++) {
//                    System.out.print(tomatoBox[y][x] + " ");
//                }
//                System.out.println();
//            }

            // [방문한 토마토 개수] + [-1의 개수] == N*M 아니면 방문하지 못한 토마토가 존재한다는 것
            System.out.println( cntVisited+cntNone==N*M ? lastDay-1 : -1);
        }

    }
    static void bfs() {
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];
            for (int d=0; d<4; d++) {
                int ny = now[0] + dy[d];
                int nx = now[1] + dx[d];
                // 범위를 벗어나거나, -1이거나, 방문한 적이 있을 때는 continue
                if ( nx<0 || ny<0 || nx>=M || ny>=N || tomatoBox[ny][nx]==-1 || visited[ny][nx] ) continue;
                q.add(new int[] {ny, nx});
                tomatoBox[ny][nx]=tomatoBox[y][x]+1;
                visited[ny][nx]=true;
                cntVisited++;
                // 큐를 다 돌렸을 때 맨 마지막에 들어있는 값이 lastDay
                lastDay = tomatoBox[ny][nx];
            }
        }
    }

}
