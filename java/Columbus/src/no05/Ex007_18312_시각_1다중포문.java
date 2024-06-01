package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex007_18312_시각_1다중포문 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/18312

        // 1. for문 돌려가며 cnt++
            // String.contain는 시간복잡도 O(n*m) (n은 검색 대상 문자열의 길이, m은 검색할 문자열의 길이)
            // 그래서 이 방법은 느리고, int로 /10, %10 를 점검하는 건 빠른가봐.
        // 2. 각 자리별 K가 포함되는 개수 & 포함베제 원리로 중복 제거

        // 한 60% 쯤에서 틀림 => 0에 대해서 1로 써버리면 안 세지만, 01로 쓰면 세 => 즉 그냥 0이 아니라 00

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        String K = st.nextToken();

        int cnt = 0;
        if (Integer.parseInt(K)!=0){
            for (int hour=0; hour<=N; hour++){
                for (int min=0; min<60; min++) {
                    for (int sec=0; sec<60; sec++) {
                        sb.setLength(0);
                        sb.append(hour).append(min).append(sec);
                        if (sb.toString().contains(K)) cnt++;
                    }
                }
            }
        } else { // K=0 이면 01, 02의 0도 세어줘야 해
            for (int hour=0; hour<=N; hour++){
                for (int min=0; min<60; min++) {
                    for (int sec=0; sec<60; sec++) {
                        sb.setLength(0);
                        sb.append(String.format("%02d", hour))
                                .append(String.format("%02d", min))
                                .append(String.format("%02d", sec));
                        if (sb.toString().contains(K)) cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }

}
