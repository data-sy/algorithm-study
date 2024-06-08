package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex016_1325_해킹_2BFS_시간초과 {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1325

        // A가 B를 신뢰한다 = B를 해킹하면 A도 해킹할 수 있다 = B -> A (방향 그래프)
        // 각 컴퓨터마다 연결된 컴터 갯수 세서 max 비교 (같으면 누적되다가 더 커지면 list 초기화)

        // cf. 우선 계속 1%에서 틀렸던 건 <=N까지 돌려야 하는데 계속 <N으로 돌렸어서야!!

        // DFS로 접근하면 가장 깊은 재귀를 찾아야 하는데 잘 안 풀렸어ㅜㅠ
        // BFS로 접근하면 queue에 들어갈 때마다 한 번씩 깊어지는 거니까 => 이걸로 깊이 구하자
            // 아! depth가 아니지!! 연결된 갯수지!!
        // sb 대신 리스트로 받아도 시간 초과

        // 함수로 따로 안 만드니까 5%까지는 진행됨. 하지만 여전히 시간 초과 ㅜㅠ

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
            adjList[B].add(A);
        }

        int max = 0;
        for (int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            cnt = 0;
            if (adjList[i].size()!=0) {
                // 원래 bfs 함수로 만들었던 부분 여기에 집어 넣음
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;

                while(!q.isEmpty()){
                    int now = q.poll();
                    for (int next : adjList[now]) {
                        if (!visited[next]){
                            q.add(next);
                            visited[next] = true;
                            cnt++;
                        }
                    }
                }
            }
            if (max<cnt) {
                sb.setLength(0);
                sb.append(i).append(' ');
                max = cnt;
            } else if (max==cnt) {
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);
    }

}
