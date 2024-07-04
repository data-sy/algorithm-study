package no09_정규식dp복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex006_9095_123더하기_DP {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/9095

        // 1 : (1) => 1가지
        // 2 : (1, 1), (2) => 2가지
        // 3 : (1, 1, 1), (2, 1), (1, 2), (3) => 4가지
        // f(i) = f(i-1) + f(i-2) + f(i-3)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[n+1];
            dp[1] = 1;
            if (n>=2) dp[2] = 2;
            if (n>=3) dp[3] = 4;
            for (int i=4; i<=n;i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            sb.append(dp[n]).append('\n');
        }
        System.out.println(sb);
    }

}
