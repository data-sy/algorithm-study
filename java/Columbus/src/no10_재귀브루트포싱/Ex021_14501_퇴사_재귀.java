package no10_재귀브루트포싱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex021_14501_퇴사_재귀 {
    static int N;
    static int[] T;
    static int[] P;
    static int max;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/17626

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        T = new int[N + 1];
        P = new int[N + 1];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        recur(0, 0);
        System.out.println(max);

    }
    static void recur(int i, int pay) {
        if (i>N) return;

        if (i==N) {
            if (pay>max) max=pay;
            return;
        }
        // i일 상담
        recur(i+T[i], pay+P[i]);
        // i일 상담 x
        recur(i+1, pay);
    }

}
