package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex021_11725_트리부모_배열 {
    static int N;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int[] parentArr;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/11725

        // 입력값 a b 에 대해서 b의 부모가 a => 아냐! 둘 중 누가 부모인지는 몰라
        // 결국 모두 담고 순회하면서 부모 찾기
        // adjList에 담고
        // 1에서 출발
            // 1에 연결된 노드들은 1을 부모로 가짐 => 부모 갱신
            // 그 노드들에 연결된 노드들은 또 그 노드를 부모로 가짐 => 부모 갱신
            // 이걸 반복해서 끝까지 진행
        // 약간 bfs 느낌으로

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // adjList 초기화
        adjList = new ArrayList[N+1];
        for (int i=0; i<=N; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adjList[A].add(B);
            adjList[B].add(A);
        }

        visited = new boolean[N + 1];
        parentArr = new int[N + 1];
        bfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i=2 ; i<=N ; i++ ) {
            sb.append(parentArr[i]).append('\n');
        }
        System.out.println(sb);

    }
    static void bfs(int i) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(i);
        visited[i]= true;

        while (!q.isEmpty()) {
            int now = q.poll(); // 부모가 될 것임
            for (int next : adjList[now] ) {
                if (!visited[next]) {
                    parentArr[next] = now;
                    q.add(next);
                    visited[next] = true;
                }
            }

        }

    }
}
