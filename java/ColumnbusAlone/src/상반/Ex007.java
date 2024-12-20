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

        // 큰 수를 작은 수로 보내기 => 필요 없음!
        // n=18, m=24 로 출발해도 while문을 돌면서 m이 24, r이 18로 되니까
//        if (n < m) {
//            int temp = n;
//            n = m;
//            m = temp;
//        }

        // r을 n%m에서 시작하면 n, m, r 순서로 넣어줘야 함 & m이 gcd
        // r을 n에서 시작하면 r, n, m 순서로 넣어줘야 함 & n이 gcd
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
