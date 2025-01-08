package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex024 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1406

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case ("L"):
                    if(!left.isEmpty()) right.push(left.pop());
                    break;
                case ("D"):
                    if(!right.isEmpty()) left.push(right.pop());
                    break;
                case ("B"):
                    if(!left.isEmpty()) left.pop();
                    break;
                case ("P"):
                    left.push(st.nextToken().charAt(0));
                    break;
            }
        }
        while(!left.isEmpty()) right.push(left.pop());
        while(!right.isEmpty()) sb.append(right.pop());

        System.out.println(sb);

    }

}
