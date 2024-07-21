package no09_정규식dp복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex010_1309_동물원_DP {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1309

        // 규칙 : 3, 7, 17, 41
        // f(n) = f(n-2) + 2*f(n-1)
            // N 자리의 xx, ox, xo로 도달할 수 있는 경우를 살펴보면
            // xx : f(n-1)
            // xo : xx 나 ox
            // ox : xx 나 xo
                // 전자(xx)는 f(n-2)
                // 후자(ox,xo)는 f(n-1)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[0]=1;
        dp[1]=3;
        for (int i=2; i<=N; i++) {
            dp[i] = (dp[i - 2] + 2*dp[i - 1])%9901;
        }
        System.out.println(dp[N]);

    }

}
