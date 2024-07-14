package no08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex048_1463_1만들기_DP {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1463

        // 원래 사용했던 방법은 N에서 /3, /2, -1을 큐에 담아서 BFS 돌리기

        // DP로 접근해보자.
        // f(n)
            // f(n-1), f(n/3), f(n/2) 중 가장 작은 것 선택해서 담기

        // 99%에서 틀림
        // 1일 때는 1이 아니라 0 => if (N>=1) dp[1]=1; 없애기 => OK

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        if (N>=2) dp[2]=1;
        if (N>=3) dp[3]=1;
        for (int i=4; i<N+1; i++) {
            int min = dp[i - 1];
            if (i%3==0) min=Math.min(dp[i/3], min);
            if (i%2==0) min=Math.min(dp[i/2], min);
            dp[i]= min+1;
        }
        System.out.println(dp[N]);

    }

}
