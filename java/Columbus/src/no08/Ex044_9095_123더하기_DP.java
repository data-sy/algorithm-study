package no08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex044_9095_123더하기_DP {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/9095

        // 구체적인 예시(1, 2, 3, 4, 5, 6)로 규칙성을 찾아보니 f(n-1) + f(n-2) + f(n-3)
        // 원리 : n자리에 오는 경우의 수가
            // f(n-1) 경우에 더하기 1을 하거나
            // f(n-2) 경우에 더하기 2를 하거나
            // f(n-3) 경우에 더하기 3을 하거나
            // 이기 때문이야!

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] tArr = new int[T];
        for (int t=0; t<T; t++) {
            tArr[t] = Integer.parseInt(br.readLine());
        }
        // 최대값 찾기
        int max = 0;
        for (int t : tArr) {
            if(max<t) max=t;
        }
        // 최대값까지 memo 채우기
        int[] memo = new int[max];
        memo[0] = 1;
        memo[1] = 2;
        memo[2] = 4;
        for (int i=3; i<max; i++) {
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
        }
        for (int t : tArr) {
            sb.append(memo[t - 1]).append('\n');
        }
        System.out.println(sb);

    }

}
