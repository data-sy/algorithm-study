package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex025 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/5397

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();

            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                switch (ch) {
                    case ('<'):
                        if (!left.isEmpty()) right.push(left.pop());
                        break;
                    case ('>'):
                        if (!right.isEmpty()) left.push(right.pop());
                        break;
                    case ('-'):
                        if (!left.isEmpty()) left.pop();
                        break;
                    default:
                        left.push(ch);
                        break;
                }
            }
            while(!left.isEmpty()) right.push(left.pop());
            while(!right.isEmpty()) sb.append(right.pop());
            sb.append('\n');
        }

        System.out.println(sb);

    }

}
