package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex016_1325_해킹_1BFS_해킹당하는입장_시간초과 {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int[] cntArr;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1325

        // A가 B를 신뢰한다 = B를 해킹하면 A도 해킹할 수 있다 = B -> A (방향 그래프)
        // 이렇게 넣으면 해킹 하는 입장에서 접근하는 것

        // A -> B로 담으면 해킹 당하는 입장에서 접근하는 것
        // 여전히 시간초과 ㅜㅠ

        // https://minhamina.tistory.com/111 자바는 시간초과 잘 나는 문제래...

        // 결론 : 이 아이디어만 남기자! 해킹 하는 입장 말고 해킹 당하는 입장에서 cntArr[next]++; 하는 방법론

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
                    // 각 원소마다 해킹 당할 때 ++
                    cntArr[next]++;
                }
            }

        }
    }

}
