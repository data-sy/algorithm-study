package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex016_1325_DFS_실패 {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int cnt;
    static int max;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1325

        // A가 B를 신뢰한다 = B를 해킹하면 A도 해킹할 수 있다 = B -> A (방향 그래프)
        // 각 컴퓨터마다 연결된 컴터 갯수 세서 max 비교 (같으면 누적되다가 더 커지면 list 초기화)

        // 한 숫자에서 dfs가 재귀로 돌아왔을 때의 길이를 재서 max를 갱신하면 visited에 for문 안 돌리고 cnt 구할 수 있을 듯!

        // 1%에서 틀림 : 순회하는 경우를 생각하지 않았음
//        5 5
//        3 1
//        3 2
//        4 3
//        5 4
//        3 5
        // 1 2 가 나와야 하는데  1 2 3 4 5 가 나와버림
        // => 개선 : dfs에서 빠져나올 때 = 스택에 쌓인 걸 하나씩 뺄 떼 = 그 때 max를 갱신하면 돼
        // 이 반례에 대해서는 개선 됨

        // 하지만 여전히 1%에서 틀려 ㅜㅠ


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

        int totalMax = 0;
        for (int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            cnt = 0;
            max = 0;
            if (adjList[i].size()!=0) dfs(i);
//            System.out.println(max);
            if (totalMax<max) {
                sb.setLength(0);
                sb.append(i).append(' ');
                totalMax = max;
            } else if (totalMax==max) {
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);

    }

    static void dfs(int now) {
        visited[now] = true;

        for (int next : adjList[now]) {
            if (!visited[next]){
                cnt++;
                dfs(next);
                // 빠져 나올 때 갱신한다면 깊이를 잴 수 있어
                if (max<cnt) max=cnt;
                cnt--;
            }
        }

    }

}
