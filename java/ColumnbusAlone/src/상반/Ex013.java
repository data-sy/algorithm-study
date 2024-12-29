package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex013 {

    public static void main (String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2004

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (m > n / 2) m = n - m;

        int cntPower2 = countPower(2, n) - countPower(2, n - m) - countPower(2, m);
        int cntPower5 = countPower(5, n) - countPower(5, n - m) - countPower(5, m);

        System.out.println(Math.min(cntPower2, cntPower5));

    }

    public static int countPower(int pow, int num) {
        int cnt = 0;
        for (int i = 1; Math.pow(pow, i) <= num; i++) {
            cnt += num / Math.pow(pow, i);
        }
        return cnt;
    }

}
