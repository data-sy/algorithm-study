package no08_기말고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ex054_2668_숫자고르기_DP {
    static int[] arr;
    static boolean[] visited;
    static boolean[] used;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2688

        // 4%에서 틀림
        // 시작과 상관 없이 내부에서 사이클이 돌 수 있음
        // 1->2->3->4->2 이렇게 돌면
            // 원래 내 풀이로는 다 visited 처리 되어버려
        // 그래서 visited는 갱신하는 대신 used로
        //


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N==1) {
            System.out.println(1);
            System.out.println(1);
        } else {
            arr = new int[N+1];
            for (int i=1; i<=N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            list = new ArrayList<>();
            used = new boolean[N + 1];
            for (int i=1; i<=N; i++) {
                if (!used[i]) {
                    visited = new boolean[N + 1];
                    list.clear();
                    if(bfs(i)) list.forEach( e -> used[e]=true);
                }
            }
            StringBuilder sb = new StringBuilder();
            int num = 0;
            for (int i=1; i<=N; i++) {
                if (used[i]) {
                    num++;
                    sb.append(i).append('\n');
                }
            }
            System.out.println(num);
            System.out.println(sb);
        }

    }
    static boolean bfs(int i) {
        list.add(i);
        visited[i] = true;
        int next = arr[i];

        if (next==i) return true;

        while (!visited[next]) {
            list.add(next);
            visited[next] = true;
            next = arr[next];
            if (next==i) return true;
        }

        return false;
    }

}
