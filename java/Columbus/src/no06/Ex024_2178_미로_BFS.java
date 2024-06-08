package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex024_2178_미로_BFS {
    static int N, M;
    static int[][] miro; // 여기에 그대로 거리 갱신
    static boolean[][] visited;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2178

        // 입력값 잘 보기 (얘는 [세로 가로] 순서로 주어짐)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        miro = new int[N][M];
        for (int y=0; y<N; y++) {
            String str = br.readLine();
            for (int x=0; x<M; x++) {
                miro[y][x] = Character.getNumericValue(str.charAt(x));
            }
        }

//        // 잘 담겼는지 확인
//        for (int y=0; y<N; y++) {
//            for (int x=0; x<M; x++) {
//                System.out.print(miro[y][x] + " ");
//            }
//            System.out.println();
//        }

        visited = new boolean[N][M];
        bfs(new int[] {0, 0});

//        // 잘 담겼는지 확인
//        for (int y=0; y<N; y++) {
//            for (int x=0; x<M; x++) {
//                System.out.print(miro[y][x] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(miro[N-1][M-1]);
    }

    static void bfs(int[] start) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(start);
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];
//            // 주의) 여기서 visited하면 메모리 초과
//            // 나중에 점검하는 건 y,x가 아니라 ny,nx잖아. 그니까 add할 때 바로 담아줘야지!!!!!
//            visited[y][x] = true;
            for (int d=0; d<4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if ( nx<0 || ny<0 || nx>=M || ny>=N || miro[ny][nx]==0 || visited[ny][nx] ) continue;
                q.add(new int[]{ny, nx});
                miro[ny][nx] = miro[y][x]+1;
                visited[ny][nx] = true;
            }

        }

    }

}
