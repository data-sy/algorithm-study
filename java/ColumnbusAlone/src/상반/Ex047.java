package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex047 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/11047

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int M = 0;
        for (int i = 0; i < N; i++) {
            int unit = Integer.parseInt(br.readLine());
            arr[i] = unit;
        }

        int cnt = 0;
        for (int i = N-1; i >= 0; i--) {
            cnt += K / arr[i];
            K %= arr[i];
            if (K==0) break;
        }
        System.out.println(cnt);

    }

}
