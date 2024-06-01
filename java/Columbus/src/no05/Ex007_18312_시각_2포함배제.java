package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex007_18312_시각_2포함배제 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/18312

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String K = st.nextToken();

        // "시"에서 쓰이는 경우 : 상한선 N이 있으므로 경우의 수 나누기 까다로워
        // 여기는 0 ~ N 까지 반복문 돌리자

        // "분(초)"에서 쓰이는 경우
        // 0 ~ 5 : 십의 자리에서 쓰일 때 10개 + 일의 자리에서 쓰일 때 6개 - 둘 다에서 쓰일 때 1개 => 15개
        // 6 ~ 9 : 일의 자리에서만 쓰임 6개

        int hour=0;
        for (int i=0; i<=N; i++){
            if (String.format("%02d", i).contains(K)) hour++;
        }
//        System.out.println(hour);
        int min = Integer.parseInt(K)<6 ? 15 : 6;
        int sec = min;

        // "포함배제 원리"로
        // + 시 + 분 + 초 - 시∩분 - 분∩초 - 시∩초 + 시∩분∩초
        int hourCnt = hour*60*60;
        int minCnt = (N+1)*min*60;
        int secCnt = (N+1)*60*sec;
        int hourMinCnt = hour*min*60;
        int minSecCnt = (N+1)*min*sec;
        int hourSecCnt = hour*60*sec;
        int hourMinSecCnt = hour*min*sec;
//        System.out.println(hourMinSecCnt);

        int cnt = hourCnt + minCnt + secCnt - hourMinCnt - minSecCnt - hourSecCnt + hourMinSecCnt;
        System.out.println(cnt);

    }

}
