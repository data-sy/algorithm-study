package no09_정규식dp복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex008_9465_스티커_DP {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/9465

        // 0 <-> 1 토글 : (k-1)*(-1). 어차피 0, 1 각각 구하기 때문에 필요 X

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[][] sticker = new int[2][n + 1];
            for (int i=0; i<2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=1; j<=n; j++) {
                    sticker[i][j] =Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][n + 1];
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];
            for (int i=2; i<=n; i++) {
                dp[0][i] = Math.max(dp[1][i-2], dp[1][i-1]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i-2], dp[0][i-1]) + sticker[1][i];
            }
            sb.append(Math.max(dp[0][n], dp[1][n])).append('\n');
        }
        System.out.println(sb);

    }

}
