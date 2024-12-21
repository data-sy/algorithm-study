package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex006 {
    static StringBuilder sb;
    static Stack<Character> stack;

    public static void main (String[] args) throws IOException {
        // https://www.acmicpc.net/problem/17413

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String str = br.readLine() + ' '; // 인덱스 에러 방지를 위해 공백 추가
        stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '<') {
                drainStack();
                while (ch != '>') {
                    sb.append(ch);
                    ch = str.charAt(++i);
                }
                sb.append(ch);
            } else {
                while (ch != ' ' && ch != '<') {
                    stack.push(ch);
                    ch = str.charAt(++i);
                }
                drainStack();
                if (ch == ' ') sb.append(ch);
                else i--;
            }
        }
        drainStack();

        sb.setLength(sb.length()-1);
        System.out.println(sb);

    }

    private static void drainStack() {
        while (!stack.isEmpty()) sb.append(stack.pop());
    }

}
