package no09_정규식dp복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex009_2193_이친수_DP {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2193

        // N=1 : 1 => 1가지
        // N=2 : 10 => 1가지
        // 직접 세어보니 2, 3, 5, 8 => 어?! 피보나치 아닐까?!
        // f(n) = f(n-1) + f(n-2)
            // 두 자리 전에서 생각하면 00, 10, 01 가능
                // 이 때 10은 그 전에 1이 있으면 안 되니까 n-1 입장에서 처리
            // f(n-1) : 0으로 끝나면 1을 붙이고 1로 끝나면 0을 붙이는 경우
                // 즉, 0으로 끝나던 1로 끝나뎐 각자 그대로 연장되므로 f(n-1)
            // f(n-2) : 0으로 끝나서 0을 붙이는 경우
                // n-2 뒤에 00을 붙이는 경우이므로 f(n-2)

        // int 를 사용하면 n<=90에 대응할 수 없어 => long으로

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+1];
        dp[1]=1;
        for (int i=2; i<=N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[N]);

    }

}
