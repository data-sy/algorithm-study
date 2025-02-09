package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex054 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2217

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int max = 0;
        for (int i = 0; i < N; i++) {
            int n = arr[i] * (N - i);
            if (max < n) max = n;
        }

        System.out.println(max);

    }
}
