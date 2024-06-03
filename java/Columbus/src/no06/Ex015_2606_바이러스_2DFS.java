package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex015_2606_바이러스_2DFS {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2606

        // 2. DFS 도 구현해보자

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        adjList = new ArrayList[N+1];
        for (int i=0; i<N+1; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adjList[A].add(B);
            adjList[B].add(A);
        }

        visited = new boolean[N+1];
        dfs(1);

        int cnt = 0;
        for (boolean visit : visited) {
            if (visit) cnt++;
        }
        // 1번 컴퓨터는 빼기
        System.out.println(cnt-1);

    }
    static void dfs(int now) {
        visited[now] = true;
        for (int next : adjList[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

}
