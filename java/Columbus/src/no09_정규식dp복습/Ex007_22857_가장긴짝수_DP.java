package no09_정규식dp복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex007_22857_가장긴짝수_DP {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/22857

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] S = new int[N+1];
        for (int i=1; i<N+1; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

    }

}
