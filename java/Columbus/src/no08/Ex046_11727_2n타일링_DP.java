package no08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex046_11727_2n타일링_DP {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/11727

        // E044_9095_123더하기 문제에서 2가 2가지로 늘어난 것
        // 크기 1 : 1가지
        // 크기 2 : ||, =, □ 3가지
        // f{n) = f(n-1) + 2*f(n-2)

        // 96%쯤에서 런타임 에러 (ArrayIndexOutOfBounds)
        // n=1일 때! 인덱스 2를 사용 못 하므로 조건문 붙여주기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] memo = new int[n+1];
        memo[0]=0;
        memo[1]=1;
        if(n>1) memo[2]=3;
        for (int i=3; i<=n; i++) {
            memo[i] = (memo[i-1]+2*memo[i-2])%10007;
        }
        System.out.println(memo[n]);

    }

}
