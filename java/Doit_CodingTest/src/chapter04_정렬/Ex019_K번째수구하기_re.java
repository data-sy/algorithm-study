package chapter04_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex019_K번째수구하기_re {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		quickSort(A, 0, A.length-1, K-1);
		System.out.println("K번째 수 : " + A[K-1]);
	
//		int[] test = {4, 5, 2, 8, 9, 1, 6, 3, 0, 7};
//		System.out.println(Arrays.toString(test));
//		quickSort(test, 0, test.length-1, 3);
//		System.out.println(Arrays.toString(test));
//		System.out.println("4번째 수 : " + test[3]); // 3

	}
	public static void quickSort(int[] A, int s, int e, int K) {
		if (s<e) {
			int p = partition(A, s, e);
			if (K==p) return;
			else if (K<p) quickSort(A, s, p-1, K);
			else quickSort(A, p+1, e, K);
		}
		
	}
	public static int partition(int[] A, int s, int e) {
		if (s+1==e) {
			if (A[s]>A[e]) swap(A, s, e);
			return e;
		}
		int mid = (s+e)/2;
		int pivot = A[mid];
		swap(A, s, mid);
		int i = s+1, j = e;
		while(i<=j) {
			while(j>0 && A[j]>pivot)j--;
			while(i<A.length && A[i]<pivot)i++;
			if (i<=j) swap(A, i++, j--);
		}
		swap(A, s, j);
		return j;
	}
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
