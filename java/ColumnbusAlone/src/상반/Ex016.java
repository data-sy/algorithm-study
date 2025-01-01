package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex016 {

    public static void main (String[] args) throws IOException {
        // https://www.acmicpc.net/problem/3986

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int bar = 0; // 쇠막대기 개수
        int result = 0; // 잘려진 조각의 총 개수
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                while (str.charAt(++i) == '(') {
                    bar++;
                    result++;
                }
                result += bar;
            } else bar--;
        }

        System.out.println(result);

    }

}
