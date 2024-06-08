package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex015_2606_바이러스_1BFS {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2606

        // BFS(1)로 모두 방문한 뒤 visited가 true인 것들 갯수 세기
            // cf. 대표값을 1로 처리하는 방법론이 있을 것 같은데.. 흠.. 이건 추가로 찾아보자

        // 1. BFS : 14268 128
        // 2. DFS : 14124 108

        // 5%에서 틀림 => 개선 : 기존 코드대로 넣으면 단방향으로 흐름. 양방향으로 각각 넣어줘야 해!

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
        bfs(1);

        int cnt = 0;
        for (boolean visit : visited) {
            if (visit) cnt++;
        }
        // 1번 컴퓨터는 빼기
        System.out.println(cnt-1);

    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();
            visited[now] = true;
            for (int next : adjList[now]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }

}
