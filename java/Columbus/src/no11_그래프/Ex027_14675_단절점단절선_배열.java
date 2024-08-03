package no11_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex027_14675_단절점단절선_배열 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/14675

        // 개수 세는 거라서 배열만으로도 충분
            // 단절점이 아닌 경우 : 엣지 개수가 1개 이하일 때
            // 단절선 : 트리에서는 모두 단절선 ok

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] edge = new int[N+1];
        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            edge[Integer.parseInt(st.nextToken())]++;
            edge[Integer.parseInt(st.nextToken())]++;
        }

        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        for (int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (t==1) { // 단절점
                if (edge[k]<=1) sb.append("no");
                else sb.append("yes");
            } else sb.append("yes");  // 단절선
            sb.append('\n');
        }
        System.out.println(sb);
    }

}
