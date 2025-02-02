package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex049 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1758

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long tip = 0;
        for (int i = N - 1; i >= 0; i--) {
            int n = arr[i] - (N - 1 - i);
            if (n < 0) break;
            tip += n;
        }

        System.out.println(tip);

    }

}
