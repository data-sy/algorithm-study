package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex044_2 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1940

        // 출제 의도대로 풀기 : 정렬, 투포인터

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int cnt = 0;
        for (int i = 0, j = N - 1; i < j; ) {
            int n = arr[i] + arr[j];
            if (n < M) i++;
            else if (M < n) j--;
            else {
                cnt++;
                i++;
            }
        }
        System.out.println(cnt);
    }

}
