package no10_재귀브루트포싱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex020_17626_라그랑주_다중포문 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/17626

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 4;
        boolean isFind = false;
        for (int a=0; a<=Math.sqrt(n); a++){
            for (int b=0; b<=Math.sqrt(n); b++){
                for (int c=0; c<=Math.sqrt(n); c++){
                    if (a*a+b*b+c*c==n){
                        cnt = 0;
                        if (a!=0) cnt++;
                        if (b!=0) cnt++;
                        if (c!=0) cnt++;
                        isFind = true;
                        break;
                    }
                } if(isFind) break;
            } if(isFind) break;
        }
        System.out.println(cnt);

    }

}
