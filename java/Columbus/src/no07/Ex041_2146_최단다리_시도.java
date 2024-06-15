package no07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex041_2146_최단다리_시도 {
    static int N;
    static int[][] map;
    static int[][] visited;
    static int num;
    static ArrayDeque<int[]> q;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2146

        // 토마토 익히듯이 모든 1에서 동시에 한 칸씩 이동하기
        // 그러다가 다른 토마토에서 이미 visisted해서 값이 든 위치를 만나면 거기가 최단 경로의 중심
        // 그 값이 N일 때 2*(N-1)+1 = 2N-1 이 실제 최단 거리
        // 서로 다른 섬이라는 건 어떻게 분리할 수 있을까?
        // visited를 int로 주자!
        // 방문한 적이 없으면 0, 방문할 때는 자기 섬 번호

        // 17%에서 틀림
        // 반례 : https://www.acmicpc.net/board/view/123397
//        6
//        1 1 0 0 0 1
//        1 1 0 0 0 1
//        0 0 0 0 0 0
//        0 0 0 0 0 0
//        0 0 0 0 0 0
//        0 1 0 0 1 1
        // 정답 2 (내 답 3)
        // 아하! 12321 로 만나는 게 아니라 1221로 만날 수도 있음
        // 그리고 처음 만나자마자 바로 break가 아니라 같은 층위만큼은 돌아봐야 해
        // 따라서 step과 min을 따로 관리하자 (경우에 따라 min 계산이 달라져)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        StringTokenizer st;
        for (int y=0; y<N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x=0; x<N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        // visited에 섬 번호 심어주기
        visited = new int[N][N];
        q = new ArrayDeque<>();
        for (int y=0; y<N; y++) {
            for (int x=0; x<N; x++) {
                // 방문한 적 없으(visited==0)면서 육지인 곳
                if (visited[y][x]==0 && map[y][x]==1) {
                    // 같은 섬의 1들 모아서 visited에 해당 num 붙여주기
                    num++;
                    dfs(y, x);
                }
            }
        }
        // 앞에서 dfs 돌리면서 q에 육지들 담아뒀음

        // 이제 bfs 돌리면서 최단 거리 찾기
        // 방문한 적 없는 바다는 visited에 그 섬의 num 심어주고, 방문한 적 있는 바다 중 다른 섬의 num을 가지고 있다면 stop
        boolean isReach = false;
        int min = 2*N;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];
            for (int d=0; d<4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                // 범위를 넘길 때, (육지이든 바다든) 같은 섬에서 이미 방문한 적이 있을 때, 육지일 때 => 컨티뉴
                if ( ny<0 || nx<0 || ny>=N || nx>=N || visited[ny][nx]==visited[y][x] || map[ny][nx]==1 ) continue;
                // 방문한 적이 없는 바다는 해당 섬 번호로 방문처리 & map에 거리 주고 & 큐에 담기
                if (visited[ny][nx]==0) {
                    visited[ny][nx]=visited[y][x];
                    map[ny][nx]=map[y][x]+1;
                    q.add(new int[]{ny, nx});
                } else { // 다른 섬에서 방문했던 적이 있으면 그 때가 최단!
                    isReach = true;
                    min = map[y][x]; //(원론적으로는 ny, nx이지만 거리를 2에서 시작했어서 마지막에 -1해줘야 하므로 그냥 y, x로 처리함)
                    break;
                }
            }
            if(isReach) break;
        }
        System.out.println(2*min-1);
//        for (int y=0; y<N; y++) {
//            for (int x=0; x<N; x++) {
//                System.out.print(map[y][x] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("=============================");
//        for (int y=0; y<N; y++) {
//            for (int x=0; x<N; x++) {
//                System.out.print(visited[y][x] + " ");
//            }
//            System.out.println();
//        }

    }
    static void dfs(int y, int x) {
        q.add(new int[]{y, x}); // 모든 육지들 미리 담아두자
        visited[y][x] = num;

        for (int d=0; d<4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            // 범위를 넘길 때, 방문한 적이 있을 때, 바다일 때 => 컨티뉴
            if ( ny<0 || nx<0 || ny>=N || nx>=N || visited[ny][nx]>0 || map[ny][nx]==0 ) continue;
            dfs(ny, nx);
        }

    }

}
