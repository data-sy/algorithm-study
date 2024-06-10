package no06_중간고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex030_14620_꽃길_조합재귀 {
    static int N, L;
    static int map[][];
    static int price[][];
    static boolean visited[][];
    static int k;
    static int sum;
    static int min;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/14620

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        L = N * N;
        StringTokenizer st;

        map = new int[N][N];
        for (int y=0; y<N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x=0; x<N; x++) {
                map[y][x] =Integer.parseInt(st.nextToken());
            }
        }
        // 가격을 미리 심어놓자
        price = new int[N][N];
        for (int y=1; y<N-1; y++) {
            for (int x=1; x<N-1; x++) {
                price[y][x] = map[y][x] + map[y - 1][x] + map[y + 1][x] + map[y][x - 1] + map[y][x + 1];
            }
        }
        visited = new boolean[N][N];
        min = 10000;
        recur(N+1); // (1, 1) 위치부터 탐색
        System.out.println(min);

    }
    static void recur(int z){
        if (k == 3) if (min>sum) min=sum;

        if (z>L) return;

        int y = z/N;
        int x = z%N;
        if ( y>=1 &&  x>=1 && y<N-1 && x<N-1 ) {
            // 자기자신과 상하좌우가 사용된 적 없을 때 선택 가능
            if (!visited[y][x] && !visited[y-1][x] && !visited[y+1][x] && !visited[y][x-1] && !visited[y][x+1] ) {
                // z를 선택할 때
                k++;
                sum += price[y][x];
                visited[y][x] = true;
                visited[y-1][x] = true;
                visited[y+1][x] = true;
                visited[y][x-1] = true;
                visited[y][x+1] = true;
                recur(z + 3);
                // 선택하지 않을 때
                k--;
                sum -= price[y][x];
                visited[y][x] = false;
                visited[y-1][x] = false;
                visited[y+1][x] = false;
                visited[y][x-1] = false;
                visited[y][x+1] = false;
                recur(z + 1);
            } else recur(z+1); // 사용된 적 있다면 다음 칸으로 이동
        } else recur(z+1);

    }

}
