package no11_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex031_13023_ABCDE_DFS {
    static int N;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/13023

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N];
        for (int i=0; i<N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adjList[A].add(B);
            adjList[B].add(A);
        }

        int result = -1;
        for (int i=0; i<N; i++) {
            visited = new boolean[N];
            result = dfs(i, 1);
            if (result==1) break;
        }
        System.out.println(result);

    }
    static int dfs(int i, int depth) {
        visited[i] = true;

        if (depth==5) return 1;

        for (int next : adjList[i]) {
            if (!visited[next]) {
                int result = dfs(next, depth+1);
                // 재귀 빠져나오면 되돌리기
                visited[next]=false;
                if(result==1) return result;
            }
        }
        return 0;
    }

}
