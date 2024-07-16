package no08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex051_9465_스티커_DP {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/11726

        // 아이디어 전혀 못 떠올림 ㅜㅠ
        // 아이디어
        // https://fbtmdwhd33.tistory.com/76
        // 다른 DP 문제에서도 그 자리에 도달할 수 있게 하는 경우를 점검한 것 처럼
        // 여기서도 먼저 내가 있는 자리에서 갈 수 있는 방향을 점검 -> 대각선 or 거기서 오른쪽
        // 이걸 반대 입장에서 설명하면 대각선 전 or 그 왼쪽
        // 그리고 0줄일 때는 1줄로 , 1줄일 때는 0줄을 선택하는 것

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n+1];
            for (int i=0; i<2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=1; j<=n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[2][n+1];
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];
            for (int i=2; i<=n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
            }
            sb.append(Math.max(dp[0][n], dp[1][n])).append('\n');
        }
        System.out.println(sb);

    }

}
