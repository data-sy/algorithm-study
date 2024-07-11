package no08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex047_2839_설탕배달_DP {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2839

        // DP로 접근해보자.
        // f(n)
            // f(n-5)가 값이 있다면 여기에 +1
            // 없다면 f(n-3)에 +1
            // 이것도 없다면 만들 수 없는 것
        // 초기값 3, 5까지 채워두기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[3]=1;
        if (N>=5) dp[5]=1;
        for (int i=6; i<N+1; i++) {
            if (dp[i-5]!=0) dp[i]=dp[i-5]+1;
            else if (dp[i-3]!=0) dp[i]=dp[i-3]+1;
        }
        System.out.println(dp[N]==0? -1 : dp[N]);

    }

}
