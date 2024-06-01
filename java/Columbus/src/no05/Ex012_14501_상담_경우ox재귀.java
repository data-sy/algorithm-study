package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex012_14501_상담_경우ox재귀 {

    static int N;
    static int[] T;
    static int[] P;
    static int max;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/14501

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        T = new int[N];
        P = new int[N];
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        recur(0, 0);

        System.out.println(max);

    }
    static void recur(int i, int pay){
//        // 상담일(T[i])이 남은 날짜(N-i)보다 크면 => 상담 불가
//        if (T[i]>N-i) return;
        // 그냥 다음 날짜가 N일을 넘기면 리턴으로 해야 모든 경우를 품을 수 있을 듯?!
        if (i>N) return;

        // i가 N이 되면 stop
        if (i==N) {
            if (pay>max) max=pay;
            return;
        }

        // i일 상담을 할 때 => T[i]일 후로 넘어 감
        recur(i+T[i], pay+P[i]);
        // i일 상담을 안 할 때 => 다음 날로 넘어 감
        recur(i+1, pay);
    }
}