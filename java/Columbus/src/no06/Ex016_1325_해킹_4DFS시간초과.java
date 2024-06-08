package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Ex016_1325_해킹_4DFS시간초과 {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int[] cntArr;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1325

        // A가 B를 신뢰한다 = B를 해킹하면 A도 해킹할 수 있다 = B -> A (방향 그래프)
        // 각 컴퓨터마다 연결된 컴터 갯수 세서 max 비교 (같으면 누적되다가 더 커지면 list 초기화)

        // 시간 초과
            // 원인1 : 모든 컴퓨터들마다 모두 dfs를 돌리는 점
            // 원인2 : dfs cnt 결과를 for문 안에서 다시 for문으로 찾는 점

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
            adjList[B].add(A);
        }

        cntArr = new int[N+1];
        for (int i=1; i<=N; i++){
            visited = new boolean[N+1];
            dfs(i);
            int cnt = 0;
            for (boolean visit : visited) {
                if (visit) cnt++;
            }
            cntArr[i] = cnt-1;
        }

        int max=0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=1; i<=N; i++) {
            if (max<cntArr[i]) {
                result.clear();
                result.add(i);
                max = cntArr[i];
            } else if (max==cntArr[i]) {
                result.add(i);
            }
        }
        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);

    }

    static void dfs(int now) {
        visited[now] = true;

        for (int next : adjList[now]) {
            if (!visited[next]){
                visited[next] = true;
                dfs(next);
            }
        }

    }

}
