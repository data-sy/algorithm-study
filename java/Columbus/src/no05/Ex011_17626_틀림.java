package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex011_17626_틀림 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/17626

        // 1%에서 틀림
        // 아! 큰 거에서 줄인다고 개수가 작은 건 아닐 수 있어!
        // 반례 48
        // 내 방법으로 찾으면 6 2 2 2가 나와. 즉 a가 제일 클 때
        // 근데 4 4 4 로 개수는 더 작을 수 있음!
        // => 결국 끝까지 다 돌려봐야 해. 브루트 포싱

        // 이렇게 다 점검하면 시간초과!

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int min = 4;
        boolean isFind = false;
        int sqrt = (int) Math.sqrt(n);
        if (sqrt*sqrt==n) System.out.println(1);
        else {
            for (int a=sqrt; 0<=a; a--){
                for (int b=sqrt; 0<=b; b--){
                    for (int c=sqrt; 0<=c; c--){
                        for (int d=sqrt; 0<=d; d--){
                            if (a*a+b*b+c*c+d*d==n){
                                int cnt = 0;
//                                System.out.println(String.format("a=%d, b=%d, c=%d, e=%d",a, b, c, d ));
                                if(a!=0) cnt++;
                                if(b!=0) cnt++;
                                if(c!=0) cnt++;
                                if(d!=0) cnt++;
                                if (cnt<min) min = cnt;
//                                isFind = true;
//                                break;
                            }
                        }
//                        if(isFind) break;
                    }
//                    if(isFind) break;
                }
//                if(isFind) break;
            }
//            System.out.println(cnt);
            System.out.println(min);
        }
    }
}