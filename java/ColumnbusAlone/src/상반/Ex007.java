package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex007 {
    public static void main (String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2609

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int product = n * m;

        int r = n % m;
        while (r != 0) {
            n = m;
            m = r;
            r = n % m;
        }
        sb.append(m).append('\n').append(product/m);
        System.out.println(sb);

    }
}
