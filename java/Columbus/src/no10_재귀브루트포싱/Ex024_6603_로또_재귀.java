package no10_재귀브루트포싱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex024_6603_로또_재귀 {
    static int k;
    static String[] S;
    static StringBuilder sb;
    static LinkedList<String> list;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/6603

        // k개 중 6개 선택 => 조합

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new LinkedList<>();
        sb = new StringBuilder();
        StringTokenizer st;

        while (true){
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k==0) break;

            S = new String[k];
            for (int i=0; i<k; i++) {
                S[i] = st.nextToken();
            }
            list.clear();
            recur(0);
            sb.append('\n');
        }
        System.out.println(sb);
    }
    static void recur(int i) {
        if (list.size()==6) {
            list.forEach(e->sb.append(e).append(' '));
            sb.append('\n');
            return;
        }
        if (i==k) return;

        // i번 포함
        list.add(S[i]);
        recur(i+1);
        // i번 포함 x
        list.removeLast();
        recur(i+1);
    }

}
