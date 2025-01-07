package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex019 {

    public static void main (String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1874

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int index = 1;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            while (index <= num) {
                stack.push(index++);
                sb.append('+').append('\n');
            }
            if (stack.peek() == num) {
                stack.pop();
                sb.append('-').append('\n');
            } else {
                sb.setLength(0);
                sb.append("NO");
                break;
            }
        }

        System.out.println(sb);

    }

}
