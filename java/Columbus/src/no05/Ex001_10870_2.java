package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex001_10870_2 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/10870

        // 1. 재귀로
        // 2. 반복문으로

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 1; i<=n; i++){
            sum+=i;
        }
        System.out.println(sum);
    }

}
