package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex026_14502_연구소_다른풀이 {
    static int N, M, maxSafeArea = 0;
    static int[][] lab, tempLab;
    static List<int[]> virusList = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/source/68717656

        // 클론 사용해서 이차원 배열 깊은 복사 가능

        // 내가 조합으로 만들었던 건 백트래킹이라고 부름 & 이중 for문으로 관리하면 활용도 좋아
        // 이 때 성능 높일 수 있는 방법으로 범위 최소화
        // x,y는 재귀로 들어오는 새 값 => 이걸 출발점으로
        // 안 쪽 for문이 끝나면 y=0으로 갱신
        // ( (x, y) 이후의 모든 애들을 의미. 손필기로 그림 ㄱㄱ)
        // k++를 이렇게 구현할 수 있구나!!! 오오!!!
//        for (int i = x; i < N; i++, y = 0) {
//            for (int j = y; j < M; j++) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];
        tempLab = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    virusList.add(new int[]{i, j});
                }
            }
        }

        buildWall(0, 0, 0);
        System.out.println(maxSafeArea);
    }

    static void buildWall(int x, int y, int count) {
        if (count == 3) {
            // 바이러스 뿌리기 위해 복사해서 사용
            // 각 행을 clone
            for (int i = 0; i < N; i++) {
                tempLab[i] = lab[i].clone();
            }
            for (int[] virus : virusList) {
                spreadVirus(virus[0], virus[1]);
            }
            maxSafeArea = Math.max(maxSafeArea, getSafeArea());
            return;
        }

        // (x, y) 이후부터 벽을 세우도록
        for (int i = x; i < N; i++, y = 0) {
            for (int j = y; j < M; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    buildWall(i, j, count + 1);
                    lab[i][j] = 0;
                }
            }
        }
    }

    // BFS에서 큐에 담는 방법론을 재귀로 구현함
    static void spreadVirus(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                // 바이러스는 복사한 값에다가 뿌려
                if (tempLab[nx][ny] == 0) {
                    tempLab[nx][ny] = 2;
                    spreadVirus(nx, ny);
                }
            }
        }
    }

    static int getSafeArea() {
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempLab[i][j] == 0) {
                    safeArea++;
                }
            }
        }
        return safeArea;
    }
}
