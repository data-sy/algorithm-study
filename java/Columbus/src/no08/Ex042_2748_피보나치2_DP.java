package no08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex042_2748_피보나치2_DP {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2748

        // n의 최대값인 90을 넣으면 int 범위를 벗어나므로 long을 써주자

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] fibo = new long[n+1];
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i=2; i<n+1; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        System.out.println(fibo[n]);

    }

}
