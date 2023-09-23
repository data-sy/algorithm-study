package chapter05_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex023_연결요소의개수_sol {
	static ArrayList<Integer>[] A;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		///////////////틀림... 뭘 잘못 적었을까?////////////
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		visited = new boolean[N+1];
		
		for(int i = 0; i <M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[a].add(b);
			A[b].add(a);
		}

		int cnt=0;
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				cnt++;
				DFS(i);
			}
		}
		System.out.println(cnt);

	}
	public static void DFS(int v) {
		if (visited[v]) return;
		
		visited[v] = true;
		for(int i : A[v]) {
			// 방문하지 않았던 노드만 탐색해야 해
			if (!visited[v]) DFS(i);
		}
		
	}
}
