package chapter04_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Ex019_K번째수구하기_sol {
	public static void main(String[] args) throws IOException {
		// 기존 답안 틀렸었음. 정오답표 참조해서 수정 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		// K번째 수를 구하므로 기본 퀵정렬에 K번째 수 찾는 것까지 포함
		quickSort(A, 0, N-1, K-1); 
		System.out.println(A[K-1]);		
		
	}
	private static void quickSort(int[] A, int s, int e, int K) {
		if (s<e) {
			int pivot = partiton(A, s, e);
			// 기본단계까지 가지 않고, K를 찾으면 재귀 끝
			// pivot의 자리가 실제 자리가 되므로
			if (pivot == K)
				return;
			// K가 pivot보다 작으면 왼쪽에서 K 찾기
			else if (K<pivot) quickSort(A, s, pivot-1, K);
			// K가 pivot보다 크면 오른쪽에서 K 찾기
			else quickSort(A, pivot+1, e, K);
		}
	}
	// pivot의 index 구하는 함수
	private static int partiton(int[] A, int s, int e) {
		// 크기 2인 배열은 정렬 후 오른쪽 리턴
		if (s+1 == e) {
			if (A[s] > A[e]) swap(A, s, e);
			return e;
		}
		// 크기 2 초과인 배열
		// s와 가운데 값 mid를 swap해서 왼쪽퀵정렬 사용 (다만 값은 mid랑 swap 했으니 시간복잡도 최악의 경우 막음)
		int mid = (s+e)/2;
		swap(A, s, mid);
		int pivot = A[s];
		// s+1 ~ e 까지 partition 돌리기
		int i = s+1, j = e;
		while (i<=j) {
			while (pivot < A[j] && j>=s+1) j--;
			while (pivot > A[i] && i<=e) i++;
			if (i<j) swap(A, i++, j--);
			else break;
		}
		// 왼쪽으로 옮겨놨던 pivot을 다시 구분 자리로 옮기기
		// i>j 가 된 j 자리는 실제로 pivot보다 작은 애가 들어있으므로 A[j]를 맨 앞인 A[s]로 옮기고
		A[s]=A[j];
		// j 자리에 pivot 넣기
		A[j]=pivot;
		return j;
	}
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
