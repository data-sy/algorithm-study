package no12_카카오기출;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex001_0806 {
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int check;
	static int graphDonutCnt;
	public static void main(String[] args) throws IOException {

//		int[][] edges = new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}};
		int[][] edges = {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};

		// 인풋에서 max 찾기
		// 왼배열 오른배열 만들어서
		// 각각 왼쪽에 있는 개수, 오른쪽에 있는 개수 카운트해서 값으로 넣어

		// 오른쪽에 있는 개수가 0개인 애는 정점 or 막대 시작
			// 0개인 애가 하나 있으면 무조건 정점 끝
			// 여러 개 있으면 => 왼쪽 카운트 체크
				// 왼쪽 카운트가 여러 개인 애는 정점
				// 하나인 애는 막대
		// 이렇게 정점 찾고 나면 - 관련 데이터 카운트 내리기
		// & 정점의 왼쪽 카운트가 그래프 개수
		// 그러면 찾기 까다로운 막대그래프는 굳이 구하지 말고
		// 도넛과 팔자를 찾자
		// 막대의 일부인 애들은 그냥 값 버리기 - 즉, 돌아서 중복되는 노드가 안 나오면 pass

		int max = 0;
		for (int i=0; i<edges.length; i++) {
			for (int j=0; j<2; j++) {
				max = Math.max(max, edges[i][j]);
			}
		}

		int[] left = new int[max+1];
		int[] right = new int[max+1];
		for (int i=0; i<edges.length; i++) {
			left[edges[i][0]]++;
			right[edges[i][1]]++;
		}
		// 잘 담겼는지 확인
//		for (int i=0; i<max+1; i++) {
//			System.out.print(left[i]+ ", ");
//		}
//		System.out.println();
//		for (int i=0; i<max+1; i++) {
//			System.out.print(right[i]+ ", ");
//		}

		// 인접행렬 초기화
		adjList = new ArrayList[max + 1];
		for (int i=0; i<=max; i++) {
			adjList[i] = new ArrayList<>();
		}
		// 인접행렬 채우기
		for (int i=0; i<edges.length; i++) {
			adjList[edges[i][0]].add(edges[i][1]);
		}

		ArrayList<Integer> rightCnt0 = new ArrayList<>();
		for (int i=0; i<=max; i++) {
			if (right[i]==0) rightCnt0.add(i);
		}
		// 정점 찾아내기
		int graphCnt = 0;
		int vertex = 0;
		if (rightCnt0.size()==1) { // 얘가 바로 정점
			vertex = rightCnt0.get(0);
		} else {
			for (int i : rightCnt0) {
				if (left[i]>1) vertex=i;
			}

		}
		graphCnt=left[vertex]; // 정점의 왼쪽이 그래프 개수

		// 정점과 연결된 선 개수 줄이기
		for (int i=0; i<edges.length; i++) {
			if (edges[i][0]==vertex) right[edges[i][1]]--;
		}

		// 왼쪽 2, 오른쪽 2인 것은 팔자의 중심
		ArrayList<Integer> center8 = new ArrayList<>();
		for (int i=0; i<=max; i++) {
			if(left[i]==2 && right[i]==2) center8.add(i);
		}
		int graph8Cnt = center8.size();

		visited = new boolean[max + 1];
		// 정점과 팔자 중심은 visited
		visited[vertex] = true;
		for (int center : center8) {
			visited[center] = true;
		}

		// 이제 정점과 팔자중심 뺀 나머지들 돌리면서
		// 돌다가 자기 자신 나오면 도넛 개수++
		// 끝나면 버려
		// 중복되는 게 내가 아닌 게 나오면 버려
		for (int i=1; i<=max; i++) {
			if (visited[i]) continue;
			check = i;
			dfs(i);
		}
		int graphBarCnt = graphCnt-graphDonutCnt-graph8Cnt;

		System.out.println("vertex : " + vertex);
		System.out.println("graphDonutCnt : " + graphDonutCnt);
		System.out.println("막대 개수 : " + graphBarCnt);
		System.out.println("graph8Cnt : " + graph8Cnt);

	}
	static void dfs (int now) {
		visited[now] = true;
		for ( int next : adjList[now]) {
			if (next==check) graphDonutCnt++;
			if (visited[next]) continue;
			dfs(next);
		}
	}

}
