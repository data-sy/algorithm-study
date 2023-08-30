package chapter03_자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Ex019_K번째수구하기_sol {
	public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		quickSort(A, 0, N-1, K-1); 
		System.out.println(A[K-1]);		
		
	}
	private static void quickSort(int[] A, int s, int e, int K) {
		if (s<e) {
			int pivot = partiton(A, s, e);
			if (pivot == K)
				return;
			else if (K<pivot) quickSort(A, s, pivot-1, K);
			else quickSort(A, pivot+1, e, K);
		}
	}
	// 피벗 구하는 함수 
	private static int partiton(int[] A, int s, int e) {
		if (s+1 == e) {
			if (A[s] > A[e]) swap(A, s, e);
			return e;
		}
		int mid = (s+e)/2;
		swap(A, s, mid);
		int pivot = A[s];
		int i = s+1, j = e;
		while (i<=j) {
			while (pivot < A[j] && j>0) j--;
			while (pivot > A[i] && i<A.length-1) i++;
			if (i<=j) swap(A, i++, j--);
		}
		A[s]=A[j];
		A[j]=pivot;
		return j;
	}
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
