package no10_재귀브루트포싱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex022_2961_요리_재귀 {
    static int N;
    static long[][] arr;
    static long min;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/17626

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        arr = new long[2][N]; // 0:신맛, 1:쓴맛
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
        }
        min = 1000000000L;
        recur(0, 1, 0);
        System.out.println(min);
    }
    static void recur(int i, long shin, long sseun) {
        if (i==N) {
            long tmp = Math.abs(shin - sseun);
            // 재로를 한 번도 사용하지 x = 쓴 맛을 한 번도 사용한 적이 없다면 0 (쓴 맛은 양수라서)
            if (sseun!=0 && min>tmp) min=tmp;
            return;
        }
        // i번째 재료 사용
        recur(i+1, shin*arr[0][i], sseun+arr[1][i]);
        // i번째 재료 사용 X
        recur(i+1, shin, sseun);
    }

}
