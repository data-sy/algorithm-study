package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex023_14675_단절_2간선개수배열 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/14675

        // 2. 간선개수배열
        // 연결된 간선의 개수만 세는 것이므로 (연결을 통해 다른 노드를 찾아가는 것이 아니라)
        // 굳이 adjList 안 만들고
        // 그냥 간선 개수를 세는 배열에 ++ 해줘서 배열 처리를 해줘도 될 것 같아!
        // OK & 살짝 더 성능 좋음

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] edgeCntArr = new int[N+1];
        StringTokenizer st;
        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            edgeCntArr[Integer.parseInt(st.nextToken())]++;
            edgeCntArr[Integer.parseInt(st.nextToken())]++;
        }
//        System.out.println(Arrays.toString(edgeCntArr));

        // 질의에 따른 답
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        for (int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (t==1) { // 단절점
                if (edgeCntArr[k]<=1) sb.append("no");
                else sb.append("yes");
            } else sb.append("yes");  // 단절선
            sb.append('\n');
        }
        System.out.println(sb);
    }

}
