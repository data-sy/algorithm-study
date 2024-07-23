package no10_재귀브루트포싱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex019_22864_피로도_구현 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/22864

        // 75%에서 틀림
            // 시간과 시간에 따른 break가 뒤로 가야 해

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int pirodo = 0;
        int hour=0;
        int work=0;
        while(hour<24){
            while(pirodo+A<=M){
                pirodo+=A;
                work+=B;
                hour++;
                if (hour>=24) break;
            }
            while(pirodo+A>M){
                pirodo-=C;
                if (pirodo<0) pirodo=0;
                hour++;
                if (hour>=24) break;
            }
        }
        System.out.println(work);

    }
}
