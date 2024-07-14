package no08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex049_22857_가장긴짝수_DP__ {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/22857

        // 8 2
        // [ 2 2 2 2 1 1 ] 1 1
        // 1 1 [ 1 1 2 2 2 2 ]

        // 얘는 90%에서 틀림

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 수열의 길이가 1일 때
        if (N==1) {
            System.out.println(0);
        } else { // 2 이상일 때
            int[] arr = new int[N+1];
            int[] memo = new int[N+1]; // 홀수의 개수를 미리 세어두기
            st = new StringTokenizer(br.readLine());
            for (int i=1; i<=N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i]%2==1) memo[i]=memo[i-1]+1;
                else memo[i]=memo[i-1];
            }
            int max = 0;
            for (int i=1; i<N+1; i++) {
                for (int j=i+1; j<N+1; j++) {
                    if (memo[j]-memo[i-1]==K) {
                        max = Math.max(max, j-i+1-K);
//                        System.out.println(j  + ", " + i);
//                        System.out.println("len : " + (j-i+1-K));
                    }
                }
            }
            System.out.println(max);

        }

    }

}
