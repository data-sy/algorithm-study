package no08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex043_1010_다리놓기_조합정의 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1010

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (M/2<N) N=M-N;
            long num1 = 1;
            long num2 = 1;
            for (int i=0; i<N; i++) {
                num1*=M-i;
                num2*=i+1;
            }
            sb.append(num1/num2).append('\n');
        }
        System.out.println(sb);
    }

}
