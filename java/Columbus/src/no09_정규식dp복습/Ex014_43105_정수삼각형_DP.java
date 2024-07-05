package no09_정규식dp복습;

import java.io.IOException;

public class Ex014_43105_정수삼각형_DP {

    public static void main(String[] args) throws IOException {
        // https://school.programmers.co.kr/learn/courses/30/lessons/43105?language=java

//        int[][] triangle = new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int[][] triangle = new int[][] {{7}};
        // 30
        int answer = 0;

        int n = triangle.length;

        int[][] dp = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+triangle[i-1][j-1];
            }
        }

        for (int j=1; j<=n; j++) {
            int tmp = dp[n][j];
            if(answer<tmp) answer = tmp;
        }
        System.out.println(answer);
    }

}
