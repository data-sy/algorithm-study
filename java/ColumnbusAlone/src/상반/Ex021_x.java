package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Ex021_x {

    public static void main (String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1918

        // 괄호 처리를 해결 못 함

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }

    static Deque<String> mulDiv(String str) {
        Deque<String> deque = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '*' || ch == '/') deque.push(deque.pop() + str.charAt(++i) + ch);
            else{ deque.push(Character.toString(ch));}
        }
        return deque;
    }

    static String plusMinus(Deque<String> deque1) {
        Deque<String> deque2 = new LinkedList<>();
        for (String str : deque1) {
            if (str.equals("+") || str.equals("-")) {
                deque2.push(deque2.pop()+deque1.poll()+str);
            } deque2.push(str);
        }

        StringBuilder sb = new StringBuilder();
        for (String str : deque2) {
            sb.append(str);
        }
        return sb.toString();
    }

}
