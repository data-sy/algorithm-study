package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex014 {

    public static void main (String[] args) throws IOException {
        // https://www.acmicpc.net/problem/9012

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int num = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') num++;
                else num--;
                if (num < 0) break;
            }
            if (num == 0) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }

        System.out.println(sb);

    }

}
