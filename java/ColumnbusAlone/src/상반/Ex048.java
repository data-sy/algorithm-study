package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex048 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/14916

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        if (n == 1 || n == 3) cnt = -1;
        else {
            while (n % 5 != 0) {
                n -= 2;
                cnt++;
            }
            cnt += n / 5;
        }

        System.out.println(cnt);

    }

}
