package no05;

import java.io.IOException;
import java.util.LinkedList;


public class Ex000_009_중복순열재귀로 {

    static String[] arr;
    static int N;
    static int K;

    static LinkedList<String> list;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/18511

        // n∏k : n개 중 k개를 순서있게 뽑아서 나열, 중복 가능

        arr = new String[]{"A", "B", "C", "D", "E"};
        N = arr.length;
        K = 3;

        StringBuilder sb = new StringBuilder();
        list = new LinkedList<>();

        dupPermutation(0, sb);

        list.forEach(e -> System.out.print(e + ","));
        System.out.println();
        System.out.println(list.size());

    }

    public static void dupPermutation(int k, StringBuilder sb) {
        if (k==K) {
            list.add(sb.toString());
            return;
        }

        for (int i=0; i<N; i++){
            sb.append(arr[i]);
            dupPermutation(k+1, sb);
            sb.setLength(sb.length()-1);
        }
    }
}
