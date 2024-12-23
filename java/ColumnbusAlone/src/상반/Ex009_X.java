package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex009_X {

    public static void main (String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1929

        // 시간 초과

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] isCompositeArr = new boolean[N+1];

        for (int i = 2; i < N + 1; i++) {
            if (!isCompositeArr[i]) {
                if (M<=i) sb.append(i).append('\n');
                for (int j = i + 1; j < N + 1; j++) {
                    if (j % i == 0 && isCompositeArr[j]==false) isCompositeArr[j] = true;
                }
            }
        }

        System.out.println(sb);

    }

}
