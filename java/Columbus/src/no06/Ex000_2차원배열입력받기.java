package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex000_2차원배열입력받기 {
    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

// 입력값
// N : 가로 크기, M : 세로 크기
//6 4
//1 -1 0 0 0 0
//0 -1 0 0 0 0
//0 0 0 0 -1 0
//0 0 0 0 -1 1
// 각 인덱스가 [y][x]로 들어감을 주의!!!!!
// (0, 0)  (0, 1)  (0, 2)  (0, 3)  (0, 4)  (0, 5)
// (1, 0)  (1, 1)  (1, 2)  (1, 3)  (1, 4)  (1, 5)
// (2, 0)  (2, 1)  (2, 2)  (2, 3)  (2, 4)  (2, 5)
// (3, 0)  (3, 1)  (3, 2)  (3, 3)  (3, 4)  (3, 5)

        // 즉 x:N, y:M 과 연결된다 기억!!!! & [y][x] 순서로 넣기
        // 이 두 개 생각하면서 나머지 코드 짜면 돼

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // * N과 M이 뒤집어져서 배열화 *
        arr = new int[M][N];
            // 넣을 때도 가로로 한 줄씩 넣으니까 y먼저 돌리기 (반복 크기는 가로->세로 순서 그대로  M -> N)
        for (int y=0; y<M; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x=0; x<N; x++) {
                // 담을 때 x, y 뒤집어서 담아야 해!!!!!!!!
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        // 잘 담겼는지 확인
        for (int y=0; y<M; y++) {
            for (int x=0; x<N; x++) {
                System.out.print(arr[y][x] + " ");
            }
            System.out.println();
        }

    }

}
