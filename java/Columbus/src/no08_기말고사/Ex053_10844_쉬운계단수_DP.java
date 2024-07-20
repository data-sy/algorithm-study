package no08_기말고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex053_10844_쉬운계단수_DP {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/10844

        // 9+1 & 0-1 : 2개는 빼주기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[1] = 9;
        if (N>1) dp[2] = 17;
        for (int i=3; i<=N; i++) {
//            dp[i] = 2*dp[i-1]-2;
        }
        System.out.println(dp[N]);

    }
}
