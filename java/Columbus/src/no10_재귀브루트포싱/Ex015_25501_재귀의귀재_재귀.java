package no10_재귀브루트포싱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex015_25501_재귀의귀재_재귀 {
    static String str;
    static int cnt;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/25501

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t=0; t<T; t++) {
            str = br.readLine();
            sb.append(isPalindrome()).append(' ').append(cnt).append('\n');
        }
        System.out.println(sb);
    }
    static int isPalindrome() {
        cnt = 0;
        return recursion(0, str.length()-1);
    }
    static int recursion(int l, int r) {
        cnt++;
        if (l>=r) return 1;
        else if (str.charAt(l)!=str.charAt(r)) return 0;
        else return recursion(l+1, r-1);
    }

}
