package chapter04_정렬;

import java.util.Arrays;

public class Ex020_수정렬하기2_sol {
	public static int[] A, tmp;
	public static long result;
	
	public static void main(String[] args) {
		int[] test = {4, 5, 2, 6, 3, 9, 1, 0, 7, 8};
		
		mergeSort(1, 9);
		System.out.println(Arrays.toString(test));	
	}
	public static void mergeSort(int s, int e) {
		// 기본 단계 
		if (e-s<1) return;
		
		// 재귀 단계 
		int m = (s+e)/2;
		mergeSort(s, m);
		mergeSort(m+1, e);
		
		// 정렬
		// 수 비교를 위한 임시 배열 
		for (int i=s; i<=e; i++) {
			tmp[i]=A[i];
		}
		
		int i = s;
		int j = m+1;
		int k = s;
		while(i<=m && j<=e) {
			if (tmp[i]<tmp[j]) A[k++]=tmp[i++];
			else A[k++]=tmp[j++];
		}
		while(i<=m) A[k++]=tmp[i++];
		while(j<=e) A[k++]=tmp[j++];
	}
}
