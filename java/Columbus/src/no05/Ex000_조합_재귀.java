package no05;

import java.io.IOException;
import java.util.ArrayList;

public class Ex000_조합_재귀 {
    static String[] arr;
    static int N;
    static boolean[] visited;
    static int K;
    static ArrayList<String> result;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        arr = new String[]{"A", "B", "C", "D", "E"};
        N = arr.length;
        visited = new boolean[5];
        K = 3;
        result = new ArrayList<>();
        sb = new StringBuilder();

        combination(0);

        result.forEach(e-> System.out.print(e + ", "));
    }
    static void combination(int i) {
        if (sb.length()==K) {
            result.add(sb.toString());
            return;
        }
        if (i==N) return;

        // i를 포함할 때
        sb.append(arr[i]);
        combination(i+1);

        // i를 포함하지 않을 때
        sb.setLength(sb.length()-1);
        combination(i+1);

    }

}