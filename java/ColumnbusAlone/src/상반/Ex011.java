package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Ex011 {

    static final Pattern PATTERN = Pattern.compile("^[A-F]?A+F+C+[A-F]?$");

    public static void main (String[] args) throws IOException {
        // https://www.acmicpc.net/problem/9342

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            if (isMatch(br.readLine())) sb.append("Infected!").append('\n');
            else sb.append("Good").append('\n');
        }

        System.out.println(sb);

    }
    public static boolean isMatch(String str) {
        return PATTERN.matcher(str).matches();
    }

}
