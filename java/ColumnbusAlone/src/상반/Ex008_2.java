package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Ex008_2 {

    static final Pattern UPPERCASE = Pattern.compile("[A-Z]");

    public static void main (String[] args) throws IOException {
        // https://www.acmicpc.net/problem/3613

        // 에러 조건
        // C ++ : 맨 앞/뒤 언더바, 연속된 언더바
        // Java : 맨 앞 대문자
        // 언더바와 대문자 혼합

        // 아스키코드
        // 대문자 : 65 ~ 90
        // _ : 95
        // 소문자 : 97 ~ 12

        // Pattern 사용해서 대문자 유무 처리해보자

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        Boolean isError = false;
        if (str.startsWith("_") || str.endsWith("_") || str.contains("__") || str.charAt(0) <= 90) isError = true;
        else {
            if (str.contains("_")) {
                if (hasUpperCase(str)) isError = true;
                else { // C++ -> Java
                    for (int i = 0; i < str.length(); i++) {
                        char ch = str.charAt(i);
                        if (97 <= ch) sb.append(ch);
                        else sb.append(Character.toUpperCase(str.charAt(++i)));
                    }
                }
            } else { // Java -> C++
                for (int i = 0; i < str.length(); i++) {
                    char ch = str.charAt(i);
                    if (97<= ch) sb.append(ch);
                    else sb.append('_').append(Character.toLowerCase(ch));
                }
            }
        }

        if (isError) System.out.println("Error!");
        else System.out.println(sb);

    }
    public static boolean hasUpperCase(String str) {
        return UPPERCASE.matcher(str).find();
    }

}
