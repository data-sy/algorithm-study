package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex010_22864_피로도_시뮬레이션 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/22864

        // 75%에서 틀림 => 개선 : hour의 초기값을 0으로
        // 80%에서 틀림 => 개선 : while(hour<24) 으로 (기존에는 등호를 넣어버렸어. 그러면 24시일 때도 돌아가는 거잖아. 안 돼!)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int hour = 0;
        int cnt = 0;
        int sum = 0;
        boolean isFull = false;

        if (A>M) System.out.println(0);
        else {
            while(hour<24){
                // M을 넘기기 '직전'까지 일하기
                while(sum+A<=M){
                    sum+=A;
                    cnt++;
                    hour++;
                    if (hour==24) {
                        isFull = true;
                        break;
                    }
                }
                if (isFull) break;
                // 일할 수 있는 상태가 될 때 까지 휴식
                while(sum+A>M){
                    sum-=C;
                    if(sum<0) sum=0;
                    hour++;
                    if (hour==24) {
                        isFull = true;
                        break;
                    }
                }
            }
            System.out.println(cnt*B);
        }
    }
}