package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex002_25501 {

    static int cnt;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/25501

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<T; i++){
            char[] chars = br.readLine().toCharArray();
            sb.append(isPalindrome(chars)).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);

    }
    static int isPalindrome(char[] chars){
        cnt = 0;
        return recursion(chars, 0, chars.length-1);
    }
    static int recursion(char[] chars, int l, int r){
        cnt++;
        if (l>=r) return 1;
        else if (chars[l]!=chars[r]) return 0;
        else return recursion(chars, l + 1, r - 1);
    }

    // char[]로 바꾸는 것 보다, String 그대로 담고 charAt 사용하는 게 성능 사~알짝 더 좋아

}
