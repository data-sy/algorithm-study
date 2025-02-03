package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex051 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/21921

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        int max = arr[X];
        int cnt = 1;
        for (int i = X+1; i <= N; i++) {
            int n = arr[i] - arr[i-X];
            if (max < n) {
                cnt = 1;
                max = n;
            } else if (max == n) cnt++;
        }
        sb.append(max).append('\n').append(cnt);

        if (max == 0) System.out.println("SAD");
        else System.out.println(sb);
    }
}
