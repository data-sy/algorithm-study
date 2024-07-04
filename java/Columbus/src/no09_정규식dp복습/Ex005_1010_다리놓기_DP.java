package no09_정규식dp복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex005_1010_다리놓기_DP {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1010

        // DP적 접근
        // mCn = m-1Cn-1 + m-1Cn
        // 파스칼 삼각형 (이산수학 30p)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (M/2<N) N=M-N;

            long[][] dp = new long[M+1][N+1];
            for (int i=0; i<=M; i++) {
                for (int j=0; j<=N; j++) {
                    if ( i==j || j==0 ) dp[i][j]=1;
                    else if (i<j) continue;
                    else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
            sb.append(dp[M][N]).append('\n');
        }
        System.out.println(sb);

    }

}
