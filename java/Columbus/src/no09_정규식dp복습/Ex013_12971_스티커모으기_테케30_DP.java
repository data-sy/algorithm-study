package no09_정규식dp복습;

import java.io.IOException;
import java.util.Arrays;

public class Ex013_12971_스티커모으기_테케30_DP {

    public static void main(String[] args) throws IOException {
        // https://school.programmers.co.kr/learn/courses/30/lessons/12971?language=java

        // 1번 스티커를 사용할 때의 dp1은 dp1[n-1]을 확인
            // dp1[n] 확인할 필요 없는 이유 : 1번 스티커를 사용했다면 조건에 안 맞고, 사용하지 않았다면 dp2와 같아
        // 1번 스티커를 사용하지 않을 때의 dp2는 dp2[n]을 확인
            // dp2[n-1] 확인할 필요 없는 이유 : 1번 스티커를 사용했든 안 했든 dp1과 같아

        // 이 논리는 3개일 때는 사용 못해
        // 최소 ㅇ x ㅇ x 이렇게 4개여야 dp1[n-1]이 의미 있어
        // 반례
//        int[] sticker = new int[] {50, 80, 70};

        // 이렇게 하면 i번 스티커를 무조건 사용하는 경우로 점검하는거니까 안 되나봐
        // i자리에서의 최댓값이 돼야 해. i번 스티커를 사용하든 말든

        // 입력값
//        int[] sticker = new int[] {14, 6, 5, 11, 3, 9, 2, 10}; //36
//        int[] sticker = new int[] {1, 3, 2, 5, 4}; //8
//        int[] sticker = new int[] {1};
        int[] sticker = new int[] {100, 100};
//        int[] sticker = new int[] {50, 1, 2, 100};
//        int[] sticker = new int[100000];
//        for (int i=0; i<100000; i++){
//            sticker[i] = 100;
//        }

        int answer = 0;
        int n = sticker.length;

        if (n==1) answer = sticker[0];
        else if (n==2) answer = Math.max(sticker[0], sticker[1]);
        else if (n==3) {
            answer = Math.max(Math.max(sticker[0], sticker[1]), sticker[2]);
        } else {
            int[] dp1 = new int[n+1]; // 1번 스티커 사용
            int[] dp2 = new int[n+1]; // 1번 스티커 사용x
            dp1[1] = sticker[0];
            dp1[2] = dp2[2] = sticker[1];
            for (int i=3; i<=n; i++) {
                dp1[i] = Math.max(dp1[i-2], dp1[i-3])+sticker[i-1];
                dp2[i] = Math.max(dp2[i-2], dp2[i-3])+sticker[i-1];
            }
            System.out.println(Arrays.toString(dp1));
            System.out.println(Arrays.toString(dp2));
            answer = Math.max(dp1[n-1], dp2[n]);
        }
        System.out.println(answer);
    }

}
