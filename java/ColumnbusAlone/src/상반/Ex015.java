package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex015 {

    public static void main (String[] args) throws IOException {
        // https://www.acmicpc.net/problem/3986

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            stack.clear();
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (stack.isEmpty()) stack.push(ch);
                else {
                    if (stack.peek() == ch) stack.pop();
                    else stack.push(ch);
                }
            }
            if (stack.isEmpty()) cnt++;
        }

        System.out.println(cnt);

    }

}
