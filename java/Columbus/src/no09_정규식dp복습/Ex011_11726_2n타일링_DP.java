package no09_정규식dp복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex011_11726_2n타일링_DP {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/11726

        // 크기 1 : 1가지
        // 크기 2 : ||, = 2가지
        // f(n) = f(n-1) + f(n-2)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        dp[1]=1;
        if (n>=2) dp[2]=2;
        for (int i=3; i<=n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])%10007;
        }
        System.out.println(dp[n]);
    }

}
