package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex009_2 {

    public static void main (String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1929

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean isPrime = false;
        for (int i = M; i <= N; i++) {
            if (i != 1) isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i%j==0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) sb.append(i).append('\n');
        }

        System.out.println(sb);

    }

}
