package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex003 {
    public static void main (String[] args) throws IOException {
        // https://www.acmicpc.net/problem/10798

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] arr = new char[5][15];

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 5; i++) {
                if (arr[i][j]==0) continue; // '\u0000'의 아스키코드 0
                sb.append(arr[i][j]);
            }
        }

        System.out.println(sb);

    }
}
