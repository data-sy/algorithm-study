package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex019 {

    public static void main (String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1935

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        double[] alphabetArr = new double[26];
        for (int i = 0; i < N; i++) {
            alphabetArr[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (65 <= ch) stack.push(alphabetArr[ch - 65]);
            else stack.push(calculate(ch, stack.pop(), stack.pop()));
        }
        System.out.printf("%.2f", stack.pop());

    }
    public static double calculate(char ch, double num2, double num1) {
        double num = 0;
        switch (ch) {
            case '+':
                num = num1 + num2;
                break;
            case '-':
                num = num1 - num2;
                break;
            case '*':
                num = num1 * num2;
                break;
            case '/':
                num = num1 / num2;
                break;
        }
        return num;
    }

}
