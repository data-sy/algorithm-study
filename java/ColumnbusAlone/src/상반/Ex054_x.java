package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex054_x {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2217

        // 왜 컴파일 에러가 나지? => 다음 날 보니 "맞았습니다!!"로 처리되어 있음. 백준 서버 오류였나봐

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            int n = arr[i] * (N + 1 - i);
            if (max < n) max = n;
        }

        System.out.println(max);

    }
}
