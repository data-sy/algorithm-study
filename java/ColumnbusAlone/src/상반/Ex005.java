package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex005 {
    public static void main (String[] args) throws IOException {
        // https://www.acmicpc.net/problem/9996

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] patternArr = br.readLine().split("\\*");
        int patternLength = patternArr[0].length() + patternArr[1].length();
        System.out.println(patternArr[0]);
        System.out.println(patternArr[1]);

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (patternLength <= str.length()) {
                if (str.startsWith(patternArr[0]) && str.endsWith(patternArr[1])) sb.append("DA").append('\n');
                else sb.append("NE").append('\n');
            } else sb.append("NE").append('\n');
        }

        System.out.println(sb);
    }
}
