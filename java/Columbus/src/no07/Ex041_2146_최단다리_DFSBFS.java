package no07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex041_2146_최단다리_DFSBFS {
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
        // 그러다가 다른 섬에서 이미 visisted해서 값이 든 위치를 만나면 거기가 최단 경로의 중심

        // 서로 다른 섬이라는 건 어떻게 분리할 수 있을까?
        // visited를 int로 주자!
        // 방문한 적이 없으면 0, 방문할 때는 자기 섬 번호

        // 이 때, 12321 형태로 만날 수도 있고 1221 형태로 만날 수도 있으므로 분기 처리

        // 한 층위 안에서는 끝까지 돌아봐야 해 (더 짧은 거리 있을 수 있으니까)


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
        boolean isMoreShort = false;
        int min = 2*N;
        int step = min;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];
            // 찾고 나서 층위가 올라가면 stop
            if (isReach && map[y][x]>step) break;
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
                } else { // 다른 섬에서 방문했던 적이 있으면 그 때가 최단! + 같은 층위까지는 체크해야 해
                    isReach = true;
                    step = map[y][x];
                    if(map[ny][nx]==map[y][x]) isMoreShort = true;
                }
            }
            if(isReach && map[y][x]>step) break;
        }
        if (isMoreShort) System.out.println(2*step-2);
        else System.out.println(2*step-1);

        // map, visited 결과 확인
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
