package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Ex013_5568_카드놓기_순열재귀 {

    static String[] arr;
    static int n;
    static int k;
    static boolean[] visited;
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/5568

        // n개 중 k개를 순서있게 뽑아서 나열 & 중복 체크 (이거는 셋으로 하면 될 듯?!)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        arr = new String[n];
        for (int i=0; i<n; i++){
            arr[i] = br.readLine();
        }

        visited = new boolean[n];
        StringBuilder sb = new StringBuilder();
        set = new HashSet<>();

        recur(0, sb);

        System.out.println(set.size());

    }
    static void recur(int idx, StringBuilder sb){
        if (idx==k){
            set.add(sb.toString());
            return;
        }

        for (int i=0; i<n; i++){
            if (visited[i]) continue;
            visited[i] = true;
            sb.append(arr[i]);
            recur(idx+1, sb);
            visited[i] = false;
            // -1이 아니라 더했던 크기만큼 빼줘야지
            sb.setLength(sb.length()-arr[i].length());
        }
    }

}