package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex000_BFS코드템플릿 {
    static int N, M;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static StringBuilder sb;

    static int[] depthArr;

    public static void main(String[] args) throws IOException {

        // 프로그래머스 756p

        // 초기화

        // 탐색 진행
            // 현재 상태 처리
            // 전이 상태 생성 - 재귀나 반복
                // 범위 검사 : 범위 벗어나면 continue;
                // 유효성 검사 : 문제 조건 벗어나면 continue;
                // 중복 검사 : 이미 방문한 곳이면 continue;
                // (조건을 합쳐서 하나의 if문으로 진행해도 돼)
                // 상태 전이 & 방문처리

// 입력값 : 첫째 줄은 노드 개수 N, 둘째 줄은 간선 갯수 M, 나머지 N개는 한 줄에 연결된 두 노드
//7
//6
//1 2
//2 3
//1 5
//5 2
//5 6
//4 7
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 인접행렬 초기화
        adjList = new ArrayList[N + 1];
        for (int i=0; i<=N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 인접행렬 채우기
        StringTokenizer st;
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            // 양방향일 때는 두 번. 단반향일 때는 한 번
            adjList[A].add(B);
            adjList[B].add(A);
        }

        // bfs
        visited = new boolean[N + 1];
        depthArr = new int[N + 1];
        // +) 결과를 담을 자료구조 필요하다면 전역변수로 만들고 여기서 초기화 (예) 스트링빌더에 담기)
        sb = new StringBuilder();
        // 현재 코드는 3에 연결된 노드들 추출
        bfs(3);
        System.out.println(sb);

        // 각 depth 보면
        System.out.println(Arrays.toString(depthArr));

    }

    static void bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            // 필요하다면 여기서 상태 처리 (예) result에 담기 )
            sb.append(now).append(' ');
            for (int next : adjList[now]) {
                // 방법 1)
                // 여기에 범위 검사, 유효성 검사, 중복 검사 등을 추가해서 continue 처리 가능
                // if ( 조건들 ) continue;
                // 그 뒤는 그냥 진행

                // 방법 2)
                // 특정 조건 없으면 반대로 visited하지 않은 원소들만 가져와서 진행
                if (!visited[next]) {
                    q.add(next);
                    visited[next]=true;
                    // 필요하다면 여기서 depth 갱신 : 이전 depth에 ++ 하는 방식으로
                    depthArr[next] = depthArr[now] + 1;
                }
            }
        }
    }
}
