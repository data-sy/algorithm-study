package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex022_14675_단절_1인접행렬 {
    static ArrayList<Integer>[] adjList;
    static int[][] edgeArr;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/14675

        // 단절점 아닌 경우 = 간선이 1개일 때 => adjList에 arrayList 길이가 1이하일 때
        // 단절선 아닌 경우 = 단절한 양 노드 중 간선이 1이하인 경우 존재할 때
            // => 간선배열[간선번호] = 두 노드가 담긴 길이 2인 배열
            // 번호에 따른 노드 2개 찾아서 => adjList에 arrayList 길이가 1인 경우 있는지 확인
        // 아냐! 정점 입장에서 혼자 똑 떨어진 게 생길 수 있으니 이건 아냐
        // 근데 그렇게 치면.... 트리에서는 모든 간선이 단절선 아닌가????
        // 순회가 없는데 단절이 아닐 수 있음????
        // 트리에서 모든 간선은 단절선이라 처리했더니 => 성공!

        // arrayList.size() == 0 의 의미 : 혼자 동떨어진 노드
        // arrayList.size() == 1 의 의미 : 딱 하나랑만 연결된 노드 (리프. 부모도 그럴 수 있음)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 초기화
        adjList = new ArrayList[N+1];
        for (int i=0; i<=N; i++) {
            adjList[i] = new ArrayList<>();
        }
        edgeArr = new int[N][2];

        // 채우기
        StringTokenizer st;
        for (int i=1; i<=N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adjList[A].add(B);
            adjList[B].add(A);
            edgeArr[i] = new int[]{A, B};
        }

        // 질의에 따른 답
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        for (int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (t==1) { // 단절점
                if (adjList[k].size()<=1) sb.append("no");
                else sb.append("yes");
            } else { // 단절선
//                boolean isNotBridge = false;
//                int[] nodes = edgeArr[k];
//                System.out.println("노드 확인 : " + nodes[0] + " " + nodes[1]);
//                for ( int node : nodes ) {
//                    if (adjList[node].size()<=1) {
//                        isNotBridge = true;
//                        break;
//                    }
//                }
//                if (isNotBridge) sb.append("no");
//                else sb.append("yes");
                // 그냥 모든 간선은 단절선??
                sb.append("yes");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

}
