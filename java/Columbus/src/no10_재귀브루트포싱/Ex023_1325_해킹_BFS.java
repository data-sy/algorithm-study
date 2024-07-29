package no10_재귀브루트포싱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex023_1325_해킹_BFS {
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int[] cntArr;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/17626

        // 신뢰 받는 입장에서 카운트 세기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for (int i=0; i<=N; i++){
            adjList[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adjList[A].add(B);
        }
        cntArr = new int[N+1];
        for (int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            if (adjList[i].size()!=0) bfs(i);
        }
        int max = 0;
        for (int i : cntArr) if (max<i) max = i;
        for (int i=1; i<=N; i++) {
            if (cntArr[i]==max) sb.append(i).append(' ');
        }
        System.out.println(sb);
    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            for (int next : adjList[now]) {
                if (!visited[next]){
                    q.add(next);
                    visited[next] = true;
                    cntArr[next]++;
                }
            }

        }
    }

}
