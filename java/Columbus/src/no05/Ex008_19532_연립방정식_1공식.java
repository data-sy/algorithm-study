package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex008_19532_연립방정식_1공식 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/19532

        // 1. 연립방정식 해 공식 : 14112	124
        // 2. 브루트포스 : 17108 184
        // 크~게 유의미한 차이는 아닌 듯! 브루트도 충분히 빨라!

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt((st.nextToken()));
        int b = Integer.parseInt((st.nextToken()));
        int c = Integer.parseInt((st.nextToken()));
        int d = Integer.parseInt((st.nextToken()));
        int e = Integer.parseInt((st.nextToken()));
        int f = Integer.parseInt((st.nextToken()));

        int x = (c*e-b*f)/(a*e-b*d);
        int y = (a*f-c*d)/(a*e-b*d);

        sb.append(x).append(' ').append(y);
        System.out.println(sb);

    }

}
