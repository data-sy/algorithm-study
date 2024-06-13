package no07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex033_13023_ABCDE_DFS {
    static int N;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int k;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/13023

        // 45%쯤에서 틀림
        // dfs에서 빠져 나와서 작업 되돌리기는 모든 것에 해줘야 해
        // 즉, k--만 하는 게 아니라 visited[next]=false;도 해 줘야지!

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
        // dfs 돌려서 depth 5인 경우 존재하면 return 1, 없으면 return 0
        int result = -1;
        for (int i=0; i<N; i++) {
            visited = new boolean[N];
            k=0;
            result = dfs(i);
            if (result==1) break;
        }
        System.out.println(result);

    }
    static int dfs(int i) {
        k++;
        visited[i] = true;

        if (k==5) return 1;

        if (i>=N) return 0;

        for (int next : adjList[i]) {
            if (!visited[next]) {
                int result = dfs(next);
                k--;
                visited[next]=false;
                if(result==1) return result;
            }
        }
        return 0;
    }

}
