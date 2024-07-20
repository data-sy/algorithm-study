package no08_기말고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Ex052_16954_일곱난쟁이_조합 {
    static int[] arr;
    static int target;
    static LinkedList<Integer> list;
    static boolean isFind;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/16954

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        arr = new int[9];
        int all = 0;
        for (int i=0; i<9; i++) {
            int tmp = Integer.parseInt(br.readLine());
            arr[i] = tmp;
            all += tmp;
        }
        Arrays.sort(arr);

        target = all-100;
        list = new LinkedList<>();
        recur(0);
        for (int i=0; i<9; i++) {
            if (!list.contains(i)) sb.append(arr[i]).append('\n');
        }
        System.out.println(sb);


    }
    static void recur(int i) {

        if(list.size()==2) {
            if (target==arr[list.get(0)]+arr[list.get(1)]) isFind=true;
            return;
        }

        if (i==9) return;

        // i를 포함할 때
        list.add(i);
        recur(i + 1);
        if (isFind) return;

        // i를 포함하지 않을 때
        list.removeLast();
        recur(i + 1);
    }

}
