package no07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex036_2206_벽부수기_BFS {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2206

        // 출처 : https://velog.io/@yoonuk/백준-2206-벽-부수고-이동하기Java자바
        // 1. visited를 3차원으로 사용 (벽을 뚫고 지나갔을 때와 아닐 때를 담는 층위를 하나 추가)
            // 벽을 부수지 않고 탐색하는 경우 visited[N][M][0]
            // 벽을 부수고 탐색하는 경우 visited[N][M][1]
        // {부순적이 있, 없} X {벽, 길} 이렇게 4가지 경우를 분기 처리

        // 2. 필요한 정보 층위가 커져서 더 이상 int[] {y, x} 로는 부족 => 노드 생성
            // 벽을 부쉈는지 여부도 함께 관리 : 부쉈을 때랑 아닐 때 다른 노드로 큐에 담아야 하기 때문
            // 최단거리도 함께 관리 : 벽을 부쉈을 때랑 부수지 않았을 때 최단 거리가 달라질 수도 있으므로
                // 이 전에는 한 번 방문한 곳은 최초 방문이 최단 거리라서 map에 그냥 넣었는데
                // 이제는 방문의 층위가 나뉘어서 방문한 적이 있더라도 (벽을 부쉈는지 여부에 따라) 각각 거리를 점검해줘야 해

        // 3. bfs의 리턴 값으로 해당 거리를 주기, 만약 못 찾으면 -1 리턴

        // 최종 정리
        // 부순 이후로 Node의 필드 isBreak에 true담기 (부수기 전에는 false)
        // 부순 이후로 visited[1][][]에 방문처리 (부수기 전에는 visited[0][][])

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[2][N][M];
        for (int y=0; y<N; y++) {
            String str = br.readLine();
            for (int x=0; x<M; x++) {
                map[y][x] = Character.getNumericValue(str.charAt(x));
            }
        }

        System.out.println(bfs(0, 0));

    }
    static int bfs(int y, int x) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(false, y, x, 1));
        visited[0][y][x] = true;

        while(!q.isEmpty()){
            Node now = q.poll();
            y = now.y;
            x = now.x;

            // Q. 최초로 나온 것이 최단이라는 걸 어떻게 보장하지?
            // A. 회차를 돌면서 step이 늘어나는 거니까 처음 나오는 step이 최단 거리야!
            if (y==N-1 && x==M-1) return now.step;

            for (int d=0; d<4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if ( ny<0 || nx<0 || ny>=N || nx>=M ) continue;
                if (now.isBreak) { // 부순 적이 있다면?
                    if(!visited[1][ny][nx] && map[ny][nx]==0) { // (방문한 적 없는) 길로 이동 가능
                        q.add(new Node(true, ny, nx, now.step+1));
                        visited[1][ny][nx]=true;
                    }
                } else { // 부순 적이 없다면?
                    if (map[ny][nx]==1) {  // 벽이면 : 부수고 지나가기
                        q.add(new Node(true, ny, nx, now.step+1));
                        visited[1][ny][nx]=true;
                    } else if (!visited[0][ny][nx]){ // (방문한 적 없는) 길이면 : 그대로 길로 지나가기
                        q.add(new Node(false, ny, nx, now.step+1));
                        visited[0][ny][nx]=true;
                    }
                }
            }
        }
        return -1;
    }
    // 아하! 그래서 class를 사용하는 구나. 필요한 데이터가 더이상 숫자만이 아니야.
    static class Node {
        boolean isBreak;
        int y;
        int x;
        int step;
        Node(boolean isBreak, int y, int x, int step) {
            this.isBreak = isBreak;
            this.y = y;
            this.x = x;
            this.step = step;
        }
    }

}
