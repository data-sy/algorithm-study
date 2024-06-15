package no07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex035_16234_인구이동_BFS {
    static int N, L, R;
    static int[][] A;
    static boolean[][] visited;
    static ArrayList<int[]> list;
    static int sumUnion;
    static int[] dc = {0, 0, -1, 1};
    static int[] dr = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/16234

        // 99%에서 틀림
        // 이것 저것 없애보다가..모든 땅이 인접하게 되었을 때 미리 isFind로 break하는 구문 없앴더니 성공 ㅜㅠ
        // 왜 그런지는 모르겠음..

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        for (int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c=0; c<N; c++) {
                A[r][c] = Integer.parseInt(st.nextToken());
            }
        }
//        // 잘 들어갔는지 확인
//        for (int r=0; r<N; r++) {
//            for (int c=0; c<N; c++) {
//                System.out.print(A[r][c]);
//            }
//            System.out.println();
//        }
//        boolean isFind = false;
        int result = 0;
        while(true){
            visited = new boolean[N][N];
            boolean isMove = false;
            // bfs를 돌려서 각 구역의 값 누적합 & 개수 세기
            for (int r=0; r<N; r++) {
                for (int c=0; c<N; c++) {
                    if (!visited[r][c]) {
                        list = new ArrayList<>();
                        bfs(r, c);
                        // 모든 나라가 인접한 순간 break (그 값이 궁금한 건 아니니까 break 먼저)
//                        if (list.size()==N*N) {
//                            isFind = true;
//                            isMove = true;
//                            break;
//                        }
                        // (r, c)와 연결된 A[nr][nc]에 평균값 담기
                        if (list.size()>1) {
                            int avg = sumUnion/list.size();
                            for (int[] land : list) {
                                A[land[0]][land[1]] = avg;
                            }
                            isMove = true;
                        }
                    }
                }
//                if(isFind) break;
            }
            // 다 돌렸는데 모든 국경이 열리지 않았다면 인구이동 불가 break
            if(!isMove) break;

            result++;
//            if(isFind) break;
        }
        System.out.println(result);

    }
    static void bfs(int r, int c) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});
        visited[r][c]=true;
        list.add(new int[]{r, c});
        sumUnion = A[r][c];

        while(!q.isEmpty()){
            int[] now = q.poll();
            r = now[0];
            c = now[1];
            for (int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if ( nr<0 || nc<0 || nr>=N || nc>=N || visited[nr][nc] || Math.abs(A[nr][nc]-A[r][c])<L || R<Math.abs(A[nr][nc]-A[r][c])) continue;
                q.add(new int[]{nr, nc});
                visited[nr][nc]=true;
                list.add(new int[]{nr, nc});
                sumUnion += A[nr][nc];
            }
        }

    }

}
