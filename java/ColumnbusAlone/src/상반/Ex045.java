package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex045 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2559

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        int max = arr[K-1];
        for (int i = K; i < N; i++) {
            int tmp = arr[i] - arr[i - K];
            if (max < tmp) max = tmp;
        }

        System.out.println(max);


    }

}
