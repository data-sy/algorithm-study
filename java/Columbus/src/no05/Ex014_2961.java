package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex014_2961 {

    static int N;
    static long[][] arr;
    static long min;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2961

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        arr = new long[N][2];
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        min = 1000000000L;

        recur(0, 1, 0);

        System.out.println(min);

    }
    static void recur(int i, long sin, long sseun) {
        if (i==N){
            // 재료를 한 번도 사용하지 않았다는 걸 어떻게 처리할 수 있을까?
                // 쓴 맛이 양의 정수이므로 한 번이라도 사용했다면 양수. 한 번도 사용한 적 없다면 0
            long tmp = Math.abs(sin-sseun);
            if (sseun!=0 && min>tmp) min = tmp;
            return;
        }
        // 재료를 사용할 때
        recur(i+1, sin*arr[i][0], sseun+arr[i][1]);
        // 재료를 사용하지 않을 때
        recur(i+1, sin, sseun);
    }

}