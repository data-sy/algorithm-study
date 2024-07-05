package no09_정규식dp복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex013_12971_스티커모으기_DP {

    public static void main(String[] args) throws IOException {
        // https://school.programmers.co.kr/learn/courses/30/lessons/12971?language=java

        // dp[i] : i자리까지의 최대값
            // dp1 : 1번 스티커 사용 & 마지막 스티커 사용 X
            // dp2 : 1번 스티커 사용 x & 마지막까지 점검
        // 입력값
//        int[] sticker = new int[] {14, 6, 5, 11, 3, 9, 2, 10}; //36
//        int[] sticker = new int[] {1, 3, 2, 5, 4}; //8
//        int[] sticker = new int[] {1};
        int[] sticker = new int[] {100, 10, 1};
//        int[] sticker = new int[] {50, 1, 2, 100};
//        int[] sticker = new int[100000];
//        for (int i=0; i<100000; i++){
//            sticker[i] = 100;
//        }

        int answer = 0;
        int n = sticker.length;

        if (n==1) answer = sticker[0];
        else {
            int[] dp1 = new int[n+1]; // 1번 스티커 사용
            int[] dp2 = new int[n+1]; // 1번 스티커 사용x
            dp1[1] = dp1[2] = sticker[0];
            dp2[2] = sticker[1];
            for (int i=3; i<=n; i++) {
                dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i - 1]);
                dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i - 1]);
            }
            System.out.println(Arrays.toString(dp1));
            System.out.println(Arrays.toString(dp2));
            answer = Math.max(dp1[n-1], dp2[n]);
        }
        System.out.println(answer);
    }

}
