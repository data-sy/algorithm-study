package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex001_10870_피보나치_1재귀 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/10870

        // 1. 재귀로
        // 2. 반복문으로

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(pibo(n));

    }

    static int pibo(int n){
        if (n<=1) return n;
        return pibo(n-1)+pibo(n-2);
    }
}
