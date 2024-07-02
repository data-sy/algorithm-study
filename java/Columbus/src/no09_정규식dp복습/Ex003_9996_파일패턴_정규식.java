package no09_정규식dp복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Ex003_9996_파일패턴_정규식 {

    static Pattern pattern;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2870

        // String으로 시도할 때는 \\ 필요했어 ( Ex000_test 참고 : String str = "\\^a[a-z]\\*d\\$";)
        // StringBuilder로 시도할 때는 \\ 필요 없어!

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        String[] strArr = br.readLine().split("\\*");
        sb.append("^").append(strArr[0]).append("[a-z]*").append(strArr[1]).append("$");
//        System.out.println(sb.toString());
        pattern = Pattern.compile(sb.toString());

        sb.setLength(0);
        for (int i=0; i<N; i++) {
            sb.append(isMatch(br.readLine())).append('\n');
        }
        System.out.println(sb);

    }
    static String isMatch(String str) {
        if (pattern.matcher(str).matches()) return "DA";
        else return "NE";
    }

}
