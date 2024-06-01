package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex011_17626_라그랑주_다중포문 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/17626

        // 4개로는 무조건 된다고 보장해줬으니까 4는 안 돌려봐도 돼
        // 3개만 돌려서 가능하면 min. 없으면 4 이렇게 가보자!! => 성공!
        // (추가로 마지막 바퀴는 ==n 찾으면 돌릴 필요 없어. 값이 더 작아지니까 그래서 맨 마지막만 break)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int min = 4;
        int sqrt = (int) Math.sqrt(n);
        if (sqrt*sqrt==n) System.out.println(1);
        else {
            for (int a=sqrt; 0<=a; a--){
                for (int b=sqrt; 0<=b; b--){
                    for (int c=sqrt; 0<=c; c--){
                        if (a*a+b*b+c*c==n){
                            int cnt=0;
                            if(a!=0) cnt++;
                            if(b!=0) cnt++;
                            if(c!=0) cnt++;
                            if (cnt<min) min = cnt;
                            break;
                        }
                    }
                }
            }
            System.out.println(min);
        }
    }
}