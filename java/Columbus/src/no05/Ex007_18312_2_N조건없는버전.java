package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex007_18312_2_N조건없는버전 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/18312

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int K = Integer.parseInt(st.nextToken());

        // "시"에서 쓰이는 경우
        // 0 : 00 ~ 10, 20 => 12개
        // 1, 2, 3 : 0*, 1*, 2* => 3개
        // 4 ~ 9 : 0*, 1* => 2개
        // 그러면 "분,초"에서는 아얘 안 쓰도록
            //  59 - 쓰이는 경우

        // "분,초"에서 쓰이는 경우
        // 0 ~ 5 : 십의 자리에서 쓰일 때 10개 + 일의 자리에서 쓰일 때 6개 - 둘 다에서 쓰일 때 1개 => 15개
        // 6 ~ 9 : 일의 자리에서만 쓰임 6개
        // "시"에서는 안 쓰이도록 : 24 - 시에서 쓰이는 경우
        // 분 - 초 서로 사용할 때 엇갈려서는 안 쓰이는 경우 : 59 - 쓰이는 경우

        int[] hours = {12, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        int[] minSecs = {15, 15, 15, 15, 15, 15, 6, 6, 6, 6};

        int cnt = hours[K]*(59-minSecs[K])*(59-minSecs[K]);
        cnt += (24-hours[K])*minSecs[K]*(59-minSecs[K]);

        System.out.println(cnt);




    }

}
