package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Ex019_1260_DFSBFS출력 {
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1260

        // 번호가 작은 것부터 방문하도록 하기 위해 adjList에 연결된 ArrayList를 한 번 정렬

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for (int i=0; i<=N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adjList[A].add(B);
            adjList[B].add(A);
        }
        for (int i=1; i<=N; i++) {
            Collections.sort(adjList[i]);
        }

        visited = new boolean[N + 1];
        sb = new StringBuilder();
        StringBuilder totalSb = new StringBuilder();
        dfs(V);
        totalSb.append(sb).append('\n');
        // visited와 sb 모두 초기화해서 재활용
        visited = new boolean[N + 1];
        sb.setLength(0);
        bfs(V);
        totalSb.append(sb);
        System.out.println(totalSb);

    }
    static void dfs(int now) {
        visited[now] = true;
        sb.append(now).append(' ');

        for (int next : adjList[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start]=true;

        while(!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(' ');
            for (int next : adjList[now]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next]=true;
                }
            }
        }
    }

}
