package no09_정규식dp복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Ex002_9342_염색체_정규식 {
    static final Pattern pattern = Pattern.compile("^[ABCDEF]?A+F+C+[ABCDEF]?$");

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2870

        // [ABCDEF]* : A, B, C, D, E, F 각각이 0개 이상
        // [ABCDEF]? : 이렇게 해야 0개 or 1개

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<T; i++) {
            sb.append(isDNA(br.readLine())).append('\n');
        }
        System.out.println(sb);
    }
    static String isDNA (String str) {
        if (pattern.matcher(str).matches()) return "Infected!";
        else return "Good";
    }

}
