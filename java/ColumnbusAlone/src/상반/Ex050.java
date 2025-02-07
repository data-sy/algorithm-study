package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex050 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1343

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] strArr = (br.readLine()+".C").split("\\.");

        for (String str : strArr) {
            int len = str.length();
            if (str.equals("C")) break;
            if (str.equals("")) {
                sb.append(".");
                continue;
            }
            else if (len % 2 == 1) {
                sb.setLength(0);
                sb.append("-1C"); // 마지막에 하나 떼주니까 미리 하나 붙이기
                break;
            } else {
                sb.append("AAAA".repeat(len / 4));
                sb.append("B".repeat(len % 4));
            }
            sb.append(".");
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
